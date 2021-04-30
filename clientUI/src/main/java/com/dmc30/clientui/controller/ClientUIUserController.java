package com.dmc30.clientui.controller;

import com.dmc30.clientui.service.ClientUIUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "index";
    }
}
