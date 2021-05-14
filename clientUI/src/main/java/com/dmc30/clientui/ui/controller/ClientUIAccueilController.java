package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientUIAccueilController {

    UserService userService;

    @Autowired
    public ClientUIAccueilController(UserService userService) {
        this.userService = userService;
    }

    Logger logger = LoggerFactory.getLogger(ClientUIAccueilController.class);

    @GetMapping("/")
    public String getToAccueil(@RequestParam(value = "publicId", required = false) String publicId, Model theModel) {
        if (publicId!=null) {
            UtilisateurDto abonne = userService.getUtilisateurByPublicId(publicId);
            theModel.addAttribute("abonne", abonne);
        }
        LivreDto livre = new LivreDto();
        theModel.addAttribute("livre", livre);
        return "accueil";
    }
}
