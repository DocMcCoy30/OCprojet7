package com.dmc30.userapi.controller;

import com.dmc30.userapi.exception.TechnicalException;
import com.dmc30.userapi.model.dto.UserDetailsDto;
import com.dmc30.userapi.model.entity.Abonne;
import com.dmc30.userapi.model.entity.Employe;
import com.dmc30.userapi.service.contract.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;
    Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/check")
    public String status() {
        return "user-api's working!";
    }

    @PostMapping("/signin")
    public String createAbonne(@Valid @RequestBody Abonne abonne, @RequestParam int paysId) throws TechnicalException {
        String message = "L'abonné "+abonne.getNumAbonne()+" "+abonne.getPrenom()+" "+abonne.getNom()+" a bien été enregistré.";
        try {
            userService.createAbonne(abonne, paysId);
        }catch (TechnicalException e) {
            message = e.getMessage();
        }
        return message;
    }

    @PostMapping("/employe")
    public String createEmploye(@Valid @RequestBody Employe employe) {
        userService.createEmploye(employe);
        return "L'employe "+employe.getMatricule()+" "+employe.getPrenom()+" "+employe.getNom()+" a bien été enregistré.";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDetailsDto userDetailsDto) {
        String message = userService.authenticateUser(userDetailsDto);
//        Authentication auth
//                = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("user : " + auth.getPrincipal() + " / Role : " + auth.getAuthorities());
        return message;
    }

}
