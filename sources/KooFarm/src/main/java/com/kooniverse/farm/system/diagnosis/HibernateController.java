package com.kooniverse.farm.system.diagnosis;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/system/diagnosis/hibernate")
@EnableTransactionManagement
@Transactional
public class HibernateController {

    final SessionFactory hibernateSessionFactory;

    public HibernateController(SessionFactory hibernateSessionFactory) {
        this.hibernateSessionFactory = hibernateSessionFactory;
    }

    @GetMapping({"", "index"})
    public String index(Model model) {

        Session session = hibernateSessionFactory.getCurrentSession();
        Date date = (Date) session.createNativeQuery("select current_date").getSingleResult();
        String currentDate = date.toString();

        model.addAttribute("currentDate", currentDate);

        return "system/diagnosis/hibernate/index.html";
    }
}
