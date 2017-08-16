package cn.no7player.common.shiro;

import org.springframework.context.annotation.Configuration;

/**
 * shiro的配置类
 *
 * @author zhangst
 * @create 2017-08-02 11:57
 */
@Configuration
public class ShiroConfiguration {

//    @Bean(name="shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
//        ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
//        bean.setSecurityManager(manager);
//        //配置登录的url和登录成功的url
//        bean.setLoginUrl("/login");
//        bean.setSuccessUrl("/hello");
//        //配置访问权限
//        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
//        filterChainDefinitionMap.put("/logincheck", "anon");
//        filterChainDefinitionMap.put("/logout*","logout");
//        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/*.*", "authc");
//        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return bean;
//    }
//    //配置核心安全事务管理器
//    @Bean(name="securityManager")
//    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
//        System.err.println("--------------shiro已经加载----------------");
//        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
//        manager.setRealm(authRealm);
//        return manager;
//    }
//    //配置自定义的权限登录器
//    @Bean(name="authRealm")
//    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
//        AuthRealm authRealm=new AuthRealm();
//        authRealm.setCredentialsMatcher(matcher);
//        return authRealm;
//    }
//    //配置自定义的密码比较器
//    @Bean(name="credentialsMatcher")
//    public CredentialsMatcher credentialsMatcher() {
//        return new CredentialsMatcher();
//    }
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
//        return new LifecycleBeanPostProcessor();
//    }
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator creator=new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager) {
//        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(manager);
//        return advisor;
//    }
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//        resolver.setPrefix("classpath:/templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCharacterEncoding("UTF-8");
//        resolver.setCacheable(false);
//        return resolver;
//    }
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//
//        Set<IDialect> additionalDialects = new HashSet<IDialect>();
//
//        additionalDialects.add(new ShiroDialect());
//
//        templateEngine.setAdditionalDialects(additionalDialects);
//
//        return templateEngine;
//    }
}
