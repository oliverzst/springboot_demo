//package cn.no7player.common.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Security配置文件
// *
// * @author zhangst
// * @create 2017-08-09 17:40
// */
//
//@Configuration          // 配置文件
//@EnableWebSecurity      // 开启Security
//@EnableGlobalMethodSecurity(prePostEnabled = true)  //AOP
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        //忽略css.jq.img等文件
//        web.ignoring().antMatchers("/**.html","/**.css", "/images/**", "/**.js","/third-party/**");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        //路由策略和访问权限的简单配置
//        http
//                .csrf().disable() //HTTP with Disable CSRF
//                .authorizeRequests() //Authorize Request Configuration
//                .antMatchers( "/login",
//                        "/regist",
//                        "/logincheck",
//                        "/signup",
//                        "/api/**",
//                        "/**/heapdump",
//                        "/**/loggers",
//                        "/**/liquibase",
//                        "/**/logfile",
//                        "/**/flyway",
//                        "/**/auditevents",
//                        "/**/jolokia").permitAll() //放开"/api/**"：为了给被监控端免登录注册并解决Log与Logger冲突
//                .and()
////                .authorizeRequests()
////                .antMatchers("/**").hasRole("USER")
////                .antMatchers("/**").authenticated()
////                .and() //Login Form configuration for all others
//                .formLogin()  //启用默认登录页面
//                .loginPage("/login")
//                .permitAll()
//                .defaultSuccessUrl("/hello")
//                .and() //Logout Form configuration
//                .logout()
//                .deleteCookies("remove")
//                .logoutSuccessUrl("/login").permitAll()
//                .and()
//                .httpBasic();
//        //登陆页面全部权限可访问
//
//        super.configure(http);
//    }
////
////    /**
////     * 配置内存用户
////     */
////    @Autowired
////    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////            .inMemoryAuthentication()
////            .withUser("Brave").password("123").roles("USER");
////    }
//
//}
