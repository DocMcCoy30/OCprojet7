package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.shared.livre.LivreDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientUIAccueilController {

 Logger logger = LoggerFactory.getLogger(ClientUIAccueilController.class);

    @GetMapping("/")
    public String getToAccueil(Model theModel) {
        LivreDto livre = new LivreDto();
        theModel.addAttribute("livre", livre);
        return "accueil";
    }
}
