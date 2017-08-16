//package cn.no7player.common.shiro;
//
//import cn.no7player.model.Module;
//import cn.no7player.model.Role;
//import cn.no7player.model.User;
//import cn.no7player.service.UserService;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
///**
// * shiro登录认证
// *
// * @author zhangst
// * @create 2017-07-28 10:50
// */
//
//public class AuthRealm extends AuthorizingRealm {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
//        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
//        List<String> permissions=new ArrayList<>();
//        Set<Role> roles = user.getRoles();
//        if(roles.size()>0) {
//            for(Role role : roles) {
//                Set<Module> modules = role.getModules();
//                if(modules.size()>0) {
//                    for(Module module : modules) {
//                        permissions.add(module.getMname());
//                    }
//                }
//            }
//        }
//        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
//        info.addStringPermissions(permissions);//将权限放入shiro中.
//        return info;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken utoken=(UsernamePasswordToken) authenticationToken;//获取用户输入的token
//        String username = utoken.getUsername();
//        User user = userService.findByName(username);
//        return new SimpleAuthenticationInfo(user, user.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
//    }
//}
