package com.dmc30.livreservice.web.controller;

import com.dmc30.livreservice.service.contract.OuvrageService;
import com.dmc30.livreservice.service.dto.bibliotheque.OuvrageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ouvrages")
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

    /**
     * Cherche la liste des ouvrages correspondants au mot clé renseigné (identifiant interne partiel ou complet)
     * @param idInterne l'identifiant interne renseigné
     * @return la liste des ouvrages correspondants
     */
    @GetMapping("/idInterne")
    public List<OuvrageDto> getOuvragesByIdInterne (@RequestParam("idInterne") String idInterne) {
        return ouvrageService.findOuvragesByIdInterne(idInterne);
    }

    /**
     * Cherche un ouvrage par son identifiant interne (complet)
     * @param idInterne l'identifiant interne renseigné
     * @return l'ouvrage recherché
     */
    @GetMapping("/ouvrage/idInterne")
    public OuvrageDto getOuvrageByIdInterne (@RequestParam("idInterne") String idInterne) {
        return ouvrageService.findouvrageByIdInterne(idInterne);
    }

    /**
     * Recherche un ouvrage par son identifiant
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return l'ouvrage recherché
     */
    @GetMapping("/ouvrage/id")
    public OuvrageDto getOuvrageById (@RequestParam("ouvrageId") Long ouvrageId) {
        return ouvrageService.findOuvrageById(ouvrageId);
    }

    /**
     * Recherche l'identifiant du livre correspondant à un ouvrage
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return l'identifiant du livre recherché
     */
    @GetMapping(path = "/livres")
    public Long getLivreIdByOuvrageId(Long ouvrageId) {
        return ouvrageService.findLivreIdByOuvrageId(ouvrageId);
    }
}
