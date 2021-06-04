package com.dmc30.livreservice.web.controller;

import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.service.contract.LivreService;
import com.dmc30.livreservice.service.dto.livre.AuteurDto;
import com.dmc30.livreservice.service.dto.livre.LivreDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * Cherche tous les livres dans la BD
     * @return la liste des livres
     */
    @GetMapping(path = "/livres")
    public List<LivreDto> getLivres() {
        List<LivreDto> livres = livreService.findAll();
        for(LivreDto tempLivre : livres) {
           Long livreId = tempLivre.getId();
            List<AuteurDto> auteurs = auteurService.findAuteurByLivres(livreId);
           tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    /**
     * Cherche les 12 derniers livres enregistrés dans la BD
     * @return la liste des 12 derniers livres pour alimenter la page d'accueil
     */
    @GetMapping(path = "/livres/12")
    public List<LivreDto> get12LastLivres() {
        List<LivreDto>livres = livreService.findLast12();
        for(LivreDto tempLivre : livres) {
            Long livreId = tempLivre.getId();
            List<AuteurDto> auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    /**
     * Cherche les livres dont le titre correspond aux critères de recherche renseignés par l'utilisateur
     * @param motCle les critères de recherche
     * @return la liste des livres correspondant à la recherche
     */
    @PostMapping(path = "/livres/titre")
    public List<LivreDto> getLivreByTitre(@RequestParam("motCle") String motCle) {
        List<LivreDto> livres = livreService.findLivreByTitreContaining(motCle);
        List<AuteurDto> auteurs = new ArrayList<>();
        for(LivreDto tempLivre : livres) {
            Long livreId = tempLivre.getId();
            auteurs = auteurService.findAuteurByLivres(livreId);
            tempLivre.setAuteurs(auteurs);
        }
        return livres;
    }

    /**
     * Cherche et renvoie la liste des livres pour un auteur
     * @param auteurId l'identifiant de l'auteur
     * @return la liste des livres recherchés
     */
    @GetMapping(path = "/livres/auteur")
    public List<LivreDto> getLivreByAuteur(@RequestParam("auteurId") Long auteurId) {
        return livreService.findLivreByAuteur(auteurId);
    }
//    /**
//     * Cherche les livres dont l'auteur correspond aux critères de recherche renseignés par l'utilisateur
//     * @param motCle les critères de recherche
//     * @return la liste des livres correspondant à la recherche
//     */
//    @PostMapping(path = "/livres/auteur")
//    public List<LivreDto> getLivreByAuteur(@RequestParam("motCle") String motCle) {
//        List<AuteurDto> auteurs = auteurService.findAuteurByNomContaining(motCle);
//        List<LivreDto> livres = new ArrayList<>();
//        for(AuteurDto tempAuteur : auteurs) {
//            Long auteurId = tempAuteur.getId();
//            livres = livreService.findLivreByAuteur(auteurId);
//         }
//        return livres;
//    }

    /**
     * Cherche un livre par son identifiant
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
    @GetMapping(path = "/livres/id")
    public LivreDto getLivreById(@RequestParam("livreId") Long livreId) {
        return livreService.findLivreById(livreId);
    }

}
