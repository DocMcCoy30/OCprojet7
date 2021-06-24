package com.dmc30.livreservice.web.controller;

import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.service.contract.LivreService;
import com.dmc30.livreservice.service.dto.livre.AuteurDto;
import com.dmc30.livreservice.service.dto.livre.LivreDto;
import com.dmc30.livreservice.web.exception.TechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    LivreService livreService;
    AuteurService auteurService;

    @Autowired
    public LivreController(LivreService livreService, AuteurService auteurService) {
        this.livreService = livreService;
        this.auteurService = auteurService;
    }

    /**
     * Cherche tous les livres dans la BD
     *
     * @return la liste des livres
     */
    @GetMapping(path = "/all")
    public List<LivreDto> getLivres() {
        List<LivreDto> livres = livreService.findAll();
        for (LivreDto tempLivre : livres) {
            Long livreId = tempLivre.getId();
            List<AuteurDto> auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    /**
     * Cherche un livre par son identifiant
     *
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
    @GetMapping(path = "/id")
    public ResponseEntity<?> getLivreById(@RequestParam("livreId") Long livreId) {
        return livreService.findLivreById(livreId);
    }

    /**
     * Cherche les livres dont le titre correspond aux critères de recherche renseignés par l'utilisateur
     *
     * @param motCle les critères de recherche
     * @return la liste des livres correspondant à la recherche
     */
    @PostMapping(path = "/titre")
    public List<LivreDto> getLivreByTitre(@RequestParam("motCle") String motCle) {
        List<LivreDto> livres = livreService.findLivreByTitreContaining(motCle);
        List<AuteurDto> auteurs = new ArrayList<>();
        for (LivreDto tempLivre : livres) {
            Long livreId = tempLivre.getId();
            auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    /**
     * Cherche et renvoie la liste des livres pour un auteur
     *
     * @param auteurId l'identifiant de l'auteur
     * @return la liste des livres recherchés
     */
    @GetMapping(path = "/auteur")
    public List<LivreDto> getLivreByAuteur(@RequestParam("auteurId") Long auteurId) {
        return livreService.findLivreByAuteur(auteurId);
    }

    /**
     * Cherche les 12 derniers livres enregistrés dans la BD
     *
     * @return la liste des 12 derniers livres pour alimenter la page d'accueil
     */
    @GetMapping(path = "/12")
    public List<LivreDto> get12LastLivres() {
        List<LivreDto> livres = livreService.findLast12();
        for (LivreDto tempLivre : livres) {
            Long livreId = tempLivre.getId();
            List<AuteurDto> auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }
}


