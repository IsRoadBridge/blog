package com.zxq.controller.admin;

import com.zxq.pojo.User;
import com.zxq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/index")
    public String login(String username, String password, HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.findUserByUsernameAndPassword(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            System.out.println(user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message","用户名或密码错误");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }

}
