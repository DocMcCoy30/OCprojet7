package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.data.entity.livre.Auteur;
import com.dmc30.livreservice.data.entity.livre.Livre;
import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.service.contract.LivreService;
import com.dmc30.livreservice.shared.livre.LivreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LivreController {

    LivreService livreService;
    AuteurService auteurService;

    @Autowired
    public LivreController(LivreService livreService, AuteurService auteurService) {
        this.livreService = livreService;
        this.auteurService = auteurService;
    }

    @GetMapping(path = "/livres")
    public List<Livre> getLivres() {
        List<Livre> livres = livreService.findAll();
        for(Livre tempLivre : livres) {
           Long livreId = tempLivre.getId();
           List<Auteur> auteurs = auteurService.findAuteurByLivres(livreId);
           tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    @GetMapping(path = "/livres/12")
    public List<Livre> get12LastLivres() {
        List<Livre>livres = livreService.findLast12();
        for(Livre tempLivre : livres) {
            Long livreId = tempLivre.getId();
            List<Auteur> auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    @PostMapping(path = "/livres/titre")
    public List<Livre> getLivreByTitre(@RequestParam("motCle") String motCle) {
        List<Livre> livres = livreService.findLivreByTitreContaining(motCle);
        List<Auteur> auteurs = new ArrayList<>();
        for(Livre tempLivre : livres) {
            Long livreId = tempLivre.getId();
            auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    @PostMapping(path = "/livres/auteur")
    public List<Livre> getLivreByAuteur(@RequestParam("motCle") String motCle) {
        List<Auteur> auteurs = auteurService.findAuteurByNomContaining(motCle);
        List<Livre> livres = new ArrayList<>();
        for(Auteur tempAuteur : auteurs) {
            Long auteurId = tempAuteur.getId();
            livres = livreService.findLivreByAuteur(auteurId);
         }
        return livres;
    }

    @GetMapping(path = "/livres/id")
    public LivreDto getLivreById(@RequestParam("livreId") Long livreId) {
        return livreService.findLivreById(livreId);
    }
}
