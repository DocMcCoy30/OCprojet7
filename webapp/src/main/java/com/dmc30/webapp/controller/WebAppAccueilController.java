package com.dmc30.webapp.controller;

import com.dmc30.webapp.model.bean.LivreBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebAppAccueilController {

    @GetMapping("/")
    public String getToAccueil(Model theModel) {
        LivreBean livre = new LivreBean();
        theModel.addAttribute("livre", livre);
        return "index";
    }
}
