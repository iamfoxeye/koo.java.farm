package com.kooniverse.farm.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        return "member/login.html";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "member/logout.html";
    }
}
