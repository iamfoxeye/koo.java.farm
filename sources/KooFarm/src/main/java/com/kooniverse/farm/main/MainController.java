package com.kooniverse.farm.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping({"", "/main"})
    public String main(Model model) {
        return "main/main.html";
    }

    @GetMapping({"/mainJsp"})
    public String mainJsp(Model model) {
        return "main/main.jsp";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "member/login.html";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "member/logout.html";
    }
}
