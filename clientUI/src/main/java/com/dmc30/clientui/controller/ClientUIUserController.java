package com.dmc30.clientui.controller;

import com.dmc30.clientui.model.dto.utilisateur.AbonneDto;
import com.dmc30.clientui.model.dto.utilisateur.UserDetailsDto;
import com.dmc30.clientui.service.impl.ClientUIUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientUIUserController {

    Logger logger = LoggerFactory.getLogger(ClientUIUserController.class);

    ClientUIUserService userService;

    @Autowired
    public ClientUIUserController(ClientUIUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message = userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }

    @GetMapping(path = "/login")
    public String loginPage(Model theModel) {
        UserDetailsDto user = new UserDetailsDto();
//        Authentication auth
//                = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("user : " + auth.getPrincipal() + " / Role : " + auth.getAuthorities());
        theModel.addAttribute("user", user);
        return "login-page";
    }

    @PostMapping(path = "/login")
    public String login(@ModelAttribute UserDetailsDto user, Model theModel) {
        String authenticationMessage = userService.login(user);
        theModel.addAttribute("message", authenticationMessage);
        return "accueil";
    }

    @GetMapping(path = "/signin")
    public String signinPage(Model theModel) {
        AbonneDto abonne = new AbonneDto();
        theModel.addAttribute("abonne", abonne);
        return "signin-page";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute AbonneDto abonne, @RequestParam("paysId") Integer paysId, Model theModel) {
        String signinMessage = userService.signin(abonne, paysId);
        theModel.addAttribute("message", signinMessage);
        return "accueil";
    }


}
