package com.kooniverse.farm.system.diagnosis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system/diagnosis/myBatis")
public class MyBatisController {

    final MyBatisService myBatisService;

    public MyBatisController(MyBatisService myBatisService) {
        this.myBatisService = myBatisService;
    }

    @GetMapping({"", "index"})
    public String index(Model model) {
        String currentDate = myBatisService.currentDate();

        model.addAttribute("currentDate", currentDate);
        return "system/diagnosis/myBatis/index.html";
    }
}
