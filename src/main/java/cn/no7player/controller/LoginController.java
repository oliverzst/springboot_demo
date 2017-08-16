package cn.no7player.controller;

import cn.no7player.common.redis.RedisServiceImpl;
import cn.no7player.model.User;
import cn.no7player.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangst
 * @create 2017-05-26 14:44
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisServiceImpl redisService;

    @RequestMapping("/login")
    public String login(Model model) {
        return "log_in";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        request.getSession().removeAttribute("user");
        return "redirect:/login";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        return "sign_up";
    }

    @RequestMapping("/regist")
    public String regist(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByName(username);
        if (null==user) {
            user = new User();
            user.setPassword(password);
            user.setUsername(username);
            userService.save(user);
        } else {
            return "redirect:/signup";
        }
        return "redirect:/login";
    }

    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
//        Subject subject = SecurityUtils.getSubject();

        try {
//            subject.login(usernamePasswordToken);   //完成登录
//            User user=(User) subject.getPrincipal();
            User user = userService.findByName(username);
            if (null!=user && user.getPassword().equals(password)) {
//                redisService.set(username,password);
                request.getSession().setAttribute("user", user);
                return "redirect:/hello";
            } else {
                return "redirect:/login";//返回登录页面
            }
        } catch(Exception e) {
            return "redirect:/login";//返回登录页面
        }
    }

}
