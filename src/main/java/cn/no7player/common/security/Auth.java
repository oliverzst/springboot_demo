package cn.no7player.common.security;

import java.lang.annotation.*;

/**
 * Created by hank on 2017/8/15.
 * 在类或方法上添加@Auth就验证登录
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
