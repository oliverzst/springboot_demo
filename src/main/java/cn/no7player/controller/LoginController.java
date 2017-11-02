package cn.no7player.controller;

import cn.no7player.common.redis.RedisServiceImpl;
import cn.no7player.common.security.SessionContext;
import cn.no7player.model.User;
import cn.no7player.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String login() {return "log_in";}

    @RequestMapping("/login1")
    public String login1(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Boolean login_falg = SessionContext.getInstance().sessionHandlerByCacheMap(session);
        if (login_falg) {
            return "redirect:/login";
        } else {
            return "redirect:/hello";
        }
    }

    @RequestMapping("/getSession")
    public String getSession(Model model ,HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("cookies", request.getCookies());
        model.addAttribute("sessionId", session.getId());
//        return "log_in";
        return "session_show";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        SessionContext.getInstance().DelSession(session);
        session.removeAttribute("user");
        session.invalidate();
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
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                Boolean b = SessionContext.getInstance().sessionHandlerByCacheMap(session);
                if (b) {
                    return "redirect:/hello";
                } else {
                    model.addAttribute("reLogin", "对不起该用户已经有人登录，您不能重复登录!");
                    return "log_in";//返回登录页面
                }
            } else {
                model.addAttribute("reLogin", "用户名或密码错误，请重新输入！");
                return "log_in";//返回登录页面
            }
        } catch(Exception e) {
            model.addAttribute("reLogin", "系统错误，对此我很抱歉！");
            return "log_in";//返回登录页面
        }
    }

}
