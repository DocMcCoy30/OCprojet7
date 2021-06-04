package com.dmc30.livreservice.web.controller;

import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.service.dto.livre.AuteurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auteurs")
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
    @GetMapping(path = "/all")
    public List<AuteurDto> getAuteurs() {
        return auteurService.findAll();
    }

    /**
     * Cherche un auteur par son nom ou son prénom
     * @param motCle le mot-clé critere de recherche
     * @return les auteurs dont le nom ou le prénom correspondent aux critères renseignés
     */
    @GetMapping(path = "/nom")
    public List<AuteurDto> getAuteurByNomContaining(@RequestParam("motCle") String motCle) {
        return auteurService.findAuteurByNomContaining(motCle);
    }
}
