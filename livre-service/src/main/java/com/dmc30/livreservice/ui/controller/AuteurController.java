package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.shared.livre.AuteurDto;
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

    /**
     * Cherche tous les auteurs enregistrés dans la BD
     * @return le liste de tous les auteurs
     */
    @GetMapping(path = "/auteurs")
    public List<AuteurDto> getAuteurs() {
        return auteurService.findAll();
    }

    /**
     * Cherche un auteur par son nom ou son prénom
     * @param nom le nom de l'auteur
     * @param prenom le prénom de l'auteur
     * @return les auteurs dont le nom ou le prénom correspondent aux critères renseignés
     */
    @PostMapping(path = "/auteurs/nom")
    public List<AuteurDto> getAuteurByNomOrPrenom(@RequestParam("nom") String nom,
                                                 @RequestParam("prenom") String prenom) {
        return auteurService.findAuteurByNomOrPrenom(nom, prenom);
    }
}
