package com.dmc30.clientui.web.controller;

import com.dmc30.clientui.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.bean.utilisateur.UtilisateurBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmpruntController {

    Logger logger = LoggerFactory.getLogger(EmpruntController.class);

    BibliothequeService bibliothequeService;
    UserService userService;
    OuvrageService ouvrageService;
    EmpruntService empruntService;

    @Autowired
    public EmpruntController(BibliothequeService bibliothequeService,
                             UserService userService,
                             OuvrageService ouvrageService,
                             EmpruntService empruntService) {
        this.bibliothequeService = bibliothequeService;
        this.userService = userService;
        this.ouvrageService = ouvrageService;
        this.empruntService = empruntService;
    }

    @GetMapping("/showEmpruntPage")
    public ModelAndView showEmpruntPage(@RequestParam("bibliothequeId") Long bibliothequeId,
                                        @ModelAttribute CreateEmpruntBean createEmpruntBean,
                                        @RequestParam(value = "numAbonne", required = false) String numAbonne,
                                        @RequestParam(value = "idInterne", required = false) String idInterne) {

        ModelAndView theModel = new ModelAndView("emprunt-page");
        UtilisateurBean abonneSelectionne = new UtilisateurBean();
        OuvrageResponseModelBean ouvrageSelectionne = new OuvrageResponseModelBean();
        createEmpruntBean = new CreateEmpruntBean();
        List<UtilisateurBean> abonnes = new ArrayList<>();
        List<OuvrageResponseModelBean> ouvrages = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        if (numAbonne == null) numAbonne = "";
        if (idInterne == null) idInterne = "";

        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        if ((!numAbonne.equals("")) && (!idInterne.equals(""))) {
            abonneSelectionne = userService.getUtilisateurByNumAbonné(numAbonne);
            ouvrageSelectionne = ouvrageService.getOuvrageByIdInterne(idInterne);
            createEmpruntBean.setAbonneId(abonneSelectionne.getId());
            createEmpruntBean.setNumAbonne(abonneSelectionne.getNumAbonne());
            createEmpruntBean.setPrenom(abonneSelectionne.getPrenom());
            createEmpruntBean.setNom(abonneSelectionne.getNom());
            createEmpruntBean.setNumTelephone(abonneSelectionne.getNumTelephone());
            createEmpruntBean.setOuvrageId(ouvrageSelectionne.getId());
            createEmpruntBean.setIdInterne(ouvrageSelectionne.getIdInterne());
            createEmpruntBean.setTitre(ouvrageSelectionne.getTitre());
            createEmpruntBean.setAuteur(ouvrageSelectionne.getAuteur());
        } else if (!numAbonne.equals("")) {
            abonneSelectionne = userService.getUtilisateurByNumAbonné(numAbonne);
            createEmpruntBean.setAbonneId(abonneSelectionne.getId());
            createEmpruntBean.setNumAbonne(abonneSelectionne.getNumAbonne());
            createEmpruntBean.setPrenom(abonneSelectionne.getPrenom());
            createEmpruntBean.setNom(abonneSelectionne.getNom());
            createEmpruntBean.setNumTelephone(abonneSelectionne.getNumTelephone());
        } else if (!idInterne.equals("")) {
            ouvrageSelectionne = ouvrageService.getOuvrageByIdInterne(idInterne);
            createEmpruntBean.setOuvrageId(ouvrageSelectionne.getId());
            createEmpruntBean.setIdInterne(ouvrageSelectionne.getIdInterne());
            createEmpruntBean.setTitre(ouvrageSelectionne.getTitre());
            createEmpruntBean.setAuteur(ouvrageSelectionne.getAuteur());
        }
        theModel.addObject("createEmpruntBean", createEmpruntBean);
        return theModel;
    }

    @PostMapping("/createEmpruntSearchForm")
    public ModelAndView populateTheCreateEmpruntForm(@RequestParam("bibliothequeId") Long bibliothequeId,
                                                     @ModelAttribute CreateEmpruntBean createEmpruntBean,
                                                     @RequestParam(value = "numAbonne", required = false) String numAbonne,
                                                     @RequestParam(value = "idInterne", required = false) String idInterne) {

        ModelAndView theModel = new ModelAndView("emprunt-page");
        List<UtilisateurBean> abonnes = new ArrayList<>();
        List<OuvrageResponseModelBean> ouvrages = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        String message = "";

        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        if ((numAbonne.equals("")) && (idInterne.equals(""))) {
            message = "Aucuns critères renseignés pour la recherche.";
        }
        if ((numAbonne != null) && (!numAbonne.equals(""))) {
            abonnes = userService.getUtilisateursByNumAbonne(createEmpruntBean.getNumAbonne());
            if (abonnes.size() == 1) {
                createEmpruntBean.setAbonneId(abonnes.get(0).getId());
                createEmpruntBean.setNumAbonne(abonnes.get(0).getNumAbonne());
                createEmpruntBean.setPrenom(abonnes.get(0).getPrenom());
                createEmpruntBean.setNom(abonnes.get(0).getNom());
                createEmpruntBean.setNumTelephone(abonnes.get(0).getNumTelephone());
            } else {
                message = "Il y a plusieurs abonnés correspondants à votre choix";
                theModel.addObject("abonnes", abonnes);
            }

        }
        if ((idInterne != null) && (!idInterne.equals(""))) {
            ouvrages = ouvrageService.getOuvragesByIdInterne(createEmpruntBean.getIdInterne());
            if (ouvrages.size() == 1) {
                createEmpruntBean.setOuvrageId(ouvrages.get(0).getId());
                createEmpruntBean.setIdInterne(ouvrages.get(0).getIdInterne());
                createEmpruntBean.setTitre(ouvrages.get(0).getTitre());
                createEmpruntBean.setAuteur(ouvrages.get(0).getAuteur());
            } else {
                message = "Il y a plusieurs ouvrages correspondants à votre choix";
                theModel.addObject("ouvrages", ouvrages);
            }
            theModel.addObject("createEmpruntBean", createEmpruntBean);
        }
        theModel.addObject("message", message);
        return theModel;
    }

    @PostMapping("/createEmprunt")
    public ModelAndView createEmprunt(@RequestParam("bibliothequeId") Long bibliothequeId,
                                      @ModelAttribute CreateEmpruntBean createEmpruntBean) {
        ModelAndView theModel = new ModelAndView("emprunt-page");
        List<UtilisateurBean> abonnes = new ArrayList<>();
        List<OuvrageResponseModelBean> ouvrages = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        String message = "";

        logger.info("AbonneId = " + createEmpruntBean.getAbonneId());
        logger.info("OuvrageId = " + createEmpruntBean.getOuvrageId());
        empruntService.createEmprunt(createEmpruntBean);

        return theModel;
    }

}
