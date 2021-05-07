package com.dmc30.livreapi.ui.controller;

import com.dmc30.livreapi.data.entity.livre.Auteur;
import com.dmc30.livreapi.service.contract.AuteurService;
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
