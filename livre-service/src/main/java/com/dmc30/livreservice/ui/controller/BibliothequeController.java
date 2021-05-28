package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.service.contract.BibliothequeService;
import com.dmc30.livreservice.shared.bibliotheque.BibliothequeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeController {

    BibliothequeService bibliothequeService;

    @Autowired
    public BibliothequeController(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    /**
     * Cherche la liste de toutes les bibliothèques enregistrées dans la BD pour alimenter la page Index
     * @return la liste de toutes les bibliothèques
     */
    @GetMapping("/bibliotheques")
    public List<BibliothequeDto> getBibliotheques() {
        return bibliothequeService.findAll();
    }

    /**
     * Cherche une bibliothèque par son identifiant
     * @param bibliothequeId l'identifiant de la bibliothèque recherchée
     * @return la bibliothèque recherchée
     */
    @PostMapping("/bibliotheque")
    public BibliothequeDto getBibliotheque(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        return bibliothequeService.findById(bibliothequeId);
    }
}
