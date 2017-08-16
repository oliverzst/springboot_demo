package cn.no7player.controller;

import cn.no7player.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        model.addAttribute("name", user.getUsername());
        return "hello";
    }
    
}
