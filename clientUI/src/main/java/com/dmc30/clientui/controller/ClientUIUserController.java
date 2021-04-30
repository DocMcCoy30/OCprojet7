package com.dmc30.clientui.controller;

import com.dmc30.clientui.model.bean.utilisateur.AbonneBean;
import com.dmc30.clientui.model.bean.utilisateur.UserAuthenticationBean;
import com.dmc30.clientui.service.ClientUIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientUIUserController {

    ClientUIUserService userService;

    @Autowired
    public ClientUIUserController(ClientUIUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message =  userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }

    @GetMapping(path = "/login")
    public String loginPage(Model theModel){
        UserAuthenticationBean user = new UserAuthenticationBean();
        theModel.addAttribute("user", user);
        return "login-page";
    }

    @PostMapping(path = "/login")
    public String login(@ModelAttribute UserAuthenticationBean user, Model theModel) {
        String authenticationMessage = userService.login(user);
        theModel.addAttribute("message", authenticationMessage);
        return "accueil";
    }

    @GetMapping(path = "/signin")
    public String signinPage(Model theModel) {
        AbonneBean abonne = new AbonneBean();
        theModel.addAttribute("abonne", abonne);
        return "signin-page";
    }

    @PostMapping("/signin")
    public String signin(@ModelAttribute AbonneBean abonne, @RequestParam("paysId") Integer paysId, Model theModel) {
//        paysId = 1;
        String signinMessage = userService.signin(abonne, paysId);
        theModel.addAttribute("message", signinMessage);
        return "accueil";
    }


}
