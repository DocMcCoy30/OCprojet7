package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.ui.model.LivreResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * A terme, connecte l'interface utilisateur (Front) avec le microservice Livre (livre-service) via la couche service et proxy.
 */
@Controller
public class LivreController {

    Logger logger = LoggerFactory.getLogger(LivreController.class);

    LivreService livreService;
    BibliothequeService bibliothequeService;
    OuvrageService ouvrageService;

    @Autowired
    public LivreController(LivreService livreService, BibliothequeService bibliothequeService, OuvrageService ouvrageService) {
        this.livreService = livreService;
        this.bibliothequeService = bibliothequeService;
        this.ouvrageService = ouvrageService;
    }

    /**
     * Affiche la page accueil et la liste de tous les livres
     *
     * @param theModel Le Model retourné.
     * @return la vue accueil avec la liste de tous les livres de la BD.
     */
    @GetMapping("/showLivres")
    public String getLivres(Model theModel) {
        List<LivreResponseModel> livres = livreService.getLivres();
        theModel.addAttribute("livres", livres);
        return "accueil";
    }

    /**
     * Affiche la page accueil et la liste des livres recherchés
     *
     * @param theModel le Model retourné.
     * @param motCle   Le mot clé entré dans la vue, chaine de caractères que doit contenir le titre des livres recherchés.
     * @return la vue accueil avec la liste des livres dont le mot clé correspond au titre.
     */
    @PostMapping("/showLivresByTitre")
    public String getLivreByTitre(Model theModel,
                                  @RequestParam("motCle") String motCle) {
        List<LivreResponseModel> livres = livreService.getLivreByTitre(motCle);
        theModel.addAttribute("livresParTitre", livres);
        return "accueil";
    }

    /**
     * Affiche la page accueil et la liste des livres recherchés
     *
     * @param theModel le Model retourné.
     * @param motCle   Le mot-clé pour la recherche
     * @return la vue accueil avec la liste des livres dont le mot clé correspond au nom de l'auteur.
     */
    @PostMapping("/showLivresByAuteur")
    public String getLivreByAuteur(Model theModel,
                                   @RequestParam("motCle") String motCle) {
        List<LivreResponseModel> livres = livreService.getLivreByAuteur(motCle);
        theModel.addAttribute("livresParAuteur", livres);
        return "accueil";
    }

    /**
     * Affiche la page accueil après une recherche de livres dans BD selon certains critères.
     *
     * @param searchParam    L'identifiant du critère de recherche choisi (titre ou nom de l'auteur)
     * @param motCle         Le mot clé entré dans la vue, chaine de caractères que doit contenir le titre ou le nom de l'auteur des livres recherchés.
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @return la vue accueil avec la bibliothèque selectionnée, le résultat de recherche, ou un message si la recherche n'a pas aboutie.
     */
    @PostMapping("/searchLivres")
    public ModelAndView searchLivres(@RequestParam(value = "search-param", required = false) Integer searchParam,
                                     @RequestParam(value = "mot-cle", required = false) String motCle,
                                     @RequestParam("bibliothequeId") Long bibliothequeId) {
        String errorMessage = null;
        ModelAndView theModel = new ModelAndView("accueil");
        List<LivreResponseModel> livres = new ArrayList<>();

        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }

        if (searchParam != null) {
            switch (searchParam) {
                case 1:
                    livres = livreService.getLivreByTitre(motCle);
                    break;
                case 2:
                    livres = livreService.getLivreByAuteur(motCle);
                    break;
            }
        } else if (motCle.equals("")) {
            livres = livreService.get12LastLivres();
        } else if (searchParam == null) {
            errorMessage = "Selectionnez un citère de recherche !";
        }

        theModel.addObject("livres", livres);
        theModel.addObject("errorMessage", errorMessage);
        return theModel;
    }

    /**
     * Affiche la page du détail d'un livre
     *
     * @param livreId        l'identifiant du livre selectionné
     * @param bibliothequeId l'identifiant de la bibliotheque selectionnée
     * @return le détail d'un livre et le nombre d'exemplaire disponible
     */
    @GetMapping("/showLivreDetails")
    public ModelAndView getLivreDetails(@RequestParam(value = "livreId") Long livreId,
                                        @RequestParam("bibliothequeId") Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("livre-detail");
        logger.info("LivreId = " + livreId);
        if (livreId != null) {
            LivreResponseModel livreResponseModel = livreService.getLivreById(livreId);
            theModel.addObject("livre", livreResponseModel);
            int nbExDispoInOne = ouvrageService.getOuvrageDispoInOneBibliotheque(livreId, bibliothequeId);
            logger.info("Nombre d'ouvrage dispo = " + nbExDispoInOne);
            theModel.addObject("nbExDispoInOne", nbExDispoInOne);
            // test on nbExDispoInOther
            List<Object> nbExDispoInOtherElements = ouvrageService.getOuvrageDispoInOtherBibliotheque(livreId, bibliothequeId);
            if (!nbExDispoInOtherElements.isEmpty()) {
                logger.info("Nombre d'ex dispo in other : " + nbExDispoInOtherElements);
                logger.info("String obj1 = " + nbExDispoInOtherElements.get(0));
                theModel.addObject("nbExDispoInOtherElements", nbExDispoInOtherElements);
                for (Object elements : nbExDispoInOtherElements) {
                    logger.info("Objet " + nbExDispoInOtherElements.indexOf(elements) + " : " + elements);
                    logger.info("Objet " + nbExDispoInOtherElements.indexOf(elements) + " class : " + elements.getClass());
                    List<Object> elementsList = (List<Object>) elements;
                    Integer nbEx = (Integer) elementsList.get(0);
                    Integer bibliothequeIdForEx = (Integer) elementsList.get(1);
                    String bibliothequeNom = (String) elementsList.get(2);
                    logger.info("nbEx : " + nbEx);
                    logger.info("bibliothequeIdForEx : " + bibliothequeIdForEx);
                    logger.info("bibliothequeNom : " + bibliothequeNom);
                }
            }
        }
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        return theModel;
    }

}
