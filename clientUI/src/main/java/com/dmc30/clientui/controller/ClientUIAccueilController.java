package com.dmc30.clientui.controller;

import com.dmc30.clientui.model.bean.livre.LivreBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientUIAccueilController {

    @GetMapping("/")
    public String getToAccueil(Model theModel) {
        LivreBean livre = new LivreBean();
        theModel.addAttribute("livre", livre);
        return "index";
    }
}
