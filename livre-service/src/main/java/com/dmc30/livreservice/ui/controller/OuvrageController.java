package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.service.contract.OuvrageService;
import com.dmc30.livreservice.shared.bibliotheque.OuvrageDto;
import com.dmc30.livreservice.shared.livre.LivreDto;
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

    /**
     * Cherche les ouvrages disponibles par identifiant du livre
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return
     */
    @GetMapping("/ouvragesDispo")
    public List<OuvrageDto> getOuvrageDispoByLivreId(@RequestParam("livreId") Long livreId,
                                                     @RequestParam("bibliothequeId") Long bibliothequeId) {
        return ouvrageService.findOuvrageDispoByLivreId(livreId, bibliothequeId);
    }

    @GetMapping("/ouvrage")
    public OuvrageDto getOuvrageByIdInterne (@RequestParam("idInterne") String idInterne) {
        return ouvrageService.findouvrageByIdInterne(idInterne);
    }

    @GetMapping("/ouvrages")
    public List<OuvrageDto> getOuvragesByIdInterne (@RequestParam("idInterne") String idInterne) {
        return ouvrageService.findOuvragesByIdInterne(idInterne);
    }

    @GetMapping("/ouvrage/id")
    public OuvrageDto getOuvrageById (@RequestParam("ouvrageId") Long ouvrageId) {
        return ouvrageService.findOuvrageById(ouvrageId);
    }

    @GetMapping(path = "/livres/ouvrage")
    public Long getLivreIdByOuvrageId(Long ouvrageId) {
        return ouvrageService.findLivreIdByOuvrageId(ouvrageId);
    }
}
