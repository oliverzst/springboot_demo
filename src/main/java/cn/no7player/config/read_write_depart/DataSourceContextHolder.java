package cn.no7player.config.read_write_depart;

import org.apache.log4j.Logger;

/**
 * 本地线程全局变量
 *
 * @author zhangst
 * @create 2017-07-11 10:43
 */

public class DataSourceContextHolder {

    private static Logger logger = Logger.getLogger(DataSourceContextHolder.class);

    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {
        logger.debug("readreadread");
        local.set(DataSourceType.read.getType());

    }

    /**
     * 写只有一个库
     */
    public static void write() {
        logger.debug("writewritewrite");
        local.set(DataSourceType.write.getType());
    }

    public static String getJdbcType() {
        return local.get();
    }

}
