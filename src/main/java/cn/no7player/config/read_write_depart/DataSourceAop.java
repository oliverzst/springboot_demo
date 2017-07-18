package cn.no7player.config.read_write_depart;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 拦截设置本地线程变量
 *
 * @author zhangst
 * @create 2017-07-11 11:34
 */
@Aspect
@Component
public class DataSourceAop {

    private static Logger logger = Logger.getLogger(DataSourceAop.class);

    @Before("execution(* cn.no7player.mapper..*.select*(..)) || execution(* cn.no7player.mapper..*.get*(..)) || execution(* cn.no7player.mapper..*.find*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        logger.info("dataSource切换到：Read");
    }

    @Before("execution(* cn.no7player.mapper..*.insert*(..)) || execution(* cn.no7player.mapper..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        logger.info("dataSource切换到：write");
    }

}
