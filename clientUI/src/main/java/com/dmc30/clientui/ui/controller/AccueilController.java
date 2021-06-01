package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.ui.model.LivreResponseModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AccueilController {

    UserService userService;
    LivreService livreService;
    BibliothequeService bibliothequeService;

    @Autowired
    public AccueilController(UserService userService, LivreService livreService, BibliothequeService bibliothequeService) {
        this.userService = userService;
        this.livreService = livreService;
        this.bibliothequeService = bibliothequeService;
    }

    Logger logger = LoggerFactory.getLogger(AccueilController.class);

    /**
     * Affiche la vue index : page d'accueil de l'application
     *
     * @return la vue index avec la liste des bibliotheque et l'utilisateur s'il est connecté
     */
    @GetMapping("/")
    public ModelAndView showIndex(@RequestParam(value = "username", required = false) String username) {
        UtilisateurDto abonneDto = new UtilisateurDto();
        ModelAndView theModel = new ModelAndView("index");
        List<BibliothequeDto> bibliotheques = bibliothequeService.getBibliotheques();
        theModel.addObject("bibliotheques", bibliotheques);
        return theModel;
    }

    /**
     * Affiche la vue accueil de l'application
     *
     * @param bibliothequeId L'identifiant de la bibliotheque choisie dans la page index
     * @return la vue accueil avec l'utilisateur s'il est connecté, la bibliothèque selectionnée, et la liste des 12 derniers livres enregistrés dans la BD
     */
    @PostMapping("/showAccueil")
    public ModelAndView getToLast12(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {

        ModelAndView theModel = new ModelAndView("accueil");
        List<LivreResponseModel> livres = livreService.get12LastLivres();
        theModel.addObject("lastLivres", livres);
        BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
        theModel.addObject("bibliotheque", bibliotheque);
        return theModel;
    }
}
