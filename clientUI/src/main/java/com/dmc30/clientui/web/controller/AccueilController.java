package com.dmc30.clientui.web.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.UtilsMethodService;
import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.shared.bean.livre.LivreResponseModelBean;
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

    UtilsMethodService utilsMethodService;
    UserService userService;
    LivreService livreService;
    BibliothequeService bibliothequeService;

    @Autowired
    public AccueilController(UtilsMethodService utilsMethodService,
                             UserService userService,
                             LivreService livreService,
                             BibliothequeService bibliothequeService) {
        this.utilsMethodService = utilsMethodService;
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
        UtilisateurBean abonneDto = new UtilisateurBean();
        ModelAndView theModel = new ModelAndView("index");
        List<BibliothequeBean> bibliotheques = bibliothequeService.getBibliotheques();
        theModel.addObject("bibliotheques", bibliotheques);
        return theModel;
    }

    /**
     * Affiche la vue accueil de l'application
     *
     * @param bibliothequeId L'identifiant de la bibliotheque choisie dans la page index
     * @return la vue accueil avec l'utilisateur s'il est connecté, la bibliothèque selectionnée, et la liste des 12 derniers livres enregistrés dans la BD
     */
    @GetMapping("/showAccueil")
    public ModelAndView getToLast12(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("accueil");
        if (bibliothequeId==null) {
            bibliothequeId=1L;
        }
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        List<LivreResponseModelBean> livres = livreService.get12LastLivres();
        theModel.addObject("lastLivres", livres);
        return theModel;
    }
}
