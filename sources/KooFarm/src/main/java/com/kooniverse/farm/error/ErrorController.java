package com.kooniverse.farm.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping({"", "/error"})
    public String error(Model model) {
        return "error/error.html";
    }

    @GetMapping({"/404"})
    public String error404(Model model) {
        return "error/error-404.html";
    }

    @GetMapping({"/500"})
    public String error500(Model model) {
        return "error/error-500.html";
    }
}
