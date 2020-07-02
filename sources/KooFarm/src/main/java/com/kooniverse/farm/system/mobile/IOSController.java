package com.kooniverse.farm.system.mobile;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/mobile")
public class IOSController {

    @GetMapping("ios")
    public String ios(Model model) {

        return "system/mobile/ios.html";
    }
}
