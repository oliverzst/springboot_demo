package cn.no7player.controller;

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

    @RequestMapping("")
    public String login(Model model) {
        return "log_in";
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
            user.setAge(1);
            user.setId(1L);
            user.setPassword(password);
            user.setName(username);
            userService.save(user);
        }
        return "sign_up";
    }

    @RequestMapping("/logincheck")
    public String logincheck(HttpServletRequest request, Model model) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findByName(username);
        if (null!=user && user.getPassword().equals(password)) {
            return "redirect:/hello?name="+username;
        }
        return "redirect:/login";
    }

}
