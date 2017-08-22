package cn.no7player.controller;

import cn.no7player.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String greeting(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("name", user.getUsername());
        return "hello";
    }
    
}
