package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OuvrageController {

    OuvrageService ouvrageService;

    @Autowired
    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    /**
     * Cherche le nombre d'ouvrages disponibles dans une bibliothèque selectionnée
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliothèque
     * @return le nombre d'ouvrage disponible dans la bibliotheque selectinnée
     */
    @GetMapping("/ouvrageDispoInOne")
    public Integer getOuvrageDispoInOneBibliotheque(@RequestParam("livreId") Long livreId,
                                                    @RequestParam("bibliothequeId") Long bibliothequeId) {
        return ouvrageService.findOuvrageDispoInOneBibliotheque(livreId,bibliothequeId);
    }

    /**
     * Cherche le nombre d'ouvrages disponibles dans les autres bibliothèques que celle selectionné par l'utilisateur
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliothèsue selectionnée
     * @return le nombre d'ouvrages par bibliothèque (id + nom de la bibliotheque)
     */
    @GetMapping("/ouvrageDispoInOther")
    public List<Object> getOuvrageDispoInOtherBibliotheque(@RequestParam("livreId") Long livreId,
                                                            @RequestParam("bibliothequeId") Long bibliothequeId) {
        return ouvrageService.findOuvrageDispoInOtherBibiotheque(livreId,bibliothequeId);
    }

}
