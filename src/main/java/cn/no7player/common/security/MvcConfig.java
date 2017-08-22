package cn.no7player.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置拦截器
 *
 * @author zhangst
 * @create 2017-08-15 11:46
 */

@Configuration
//@EnableWebMvc
@ComponentScan(basePackages = "cn.no7player.controller")
@PropertySource(value = "classpath:application.properties",
        ignoreResourceNotFound = true,encoding = "UTF-8")
public class MvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MvcConfig.class);

//    @Autowired
//    LoginInterceptor loginInterceptor;

//    /**
//
//     * <p>
//     *     视图处理器
//     * </p>
//     *
//     * @return
//     */
//    @Bean
//    public ViewResolver viewResolver() {
//        logger.info("ViewResolver");
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/");
//        viewResolver.setSuffix(".html");
//        return viewResolver;
//    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册监控拦截器
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/signup","/logincheck","/regist");
        super.addInterceptors(registry);
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedHeaders("*/*")
//                .allowedMethods("*")
//                .maxAge(120);
//    }
//
    /**
     * 静态资源处理器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

}
