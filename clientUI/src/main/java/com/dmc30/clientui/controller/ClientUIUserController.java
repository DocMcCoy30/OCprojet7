package com.dmc30.clientui.controller;

import com.dmc30.clientui.model.bean.utilisateur.UserAuthenticationBean;
import com.dmc30.clientui.service.ClientUIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ClientUIUserController {

    ClientUIUserService userService;

    @Autowired
    public ClientUIUserController(ClientUIUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    public String loginPage(Model theModel){
        UserAuthenticationBean user = new UserAuthenticationBean();
        theModel.addAttribute("user", user);
        return "login-page";
    }

    @PostMapping(path = "/login")
    public String login(@RequestBody UserAuthenticationBean user, Model theModel) {
        String authenticationMessage = userService.login(user);
        theModel.addAttribute("authentication-message", authenticationMessage);
        return "accueil";
    }

    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message =  userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }
}
