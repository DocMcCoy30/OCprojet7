package com.dmc30.livreapi.controller;

import com.dmc30.livreapi.model.entity.Auteur;
import com.dmc30.livreapi.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuteurController {

    AuteurService auteurService;

    @Autowired
    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @GetMapping(path = "/auteurs")
    public List<Auteur> getAuteurs() {
        return auteurService.findAll();
    }

    @PostMapping(path = "/auteurs/nom")
    public List<Auteur> getAuteurByNomOrPrenom(@RequestParam("nom") String nom,
                                              @RequestParam("prenom") String prenom) {
        return auteurService.findAuteurByNomOrPrenom(nom, prenom);
    }
}
