package com.dmc30.clientui.web.controller;

import com.dmc30.clientui.bean.bibliotheque.*;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.bean.utilisateur.UtilisateurBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
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
        List<OuvrageResponseModelBean> ouvragesByBibliotheque = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        if (numAbonne == null) numAbonne = "";
        if (idInterne == null) idInterne = "";
        String message = "";

        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        if ((!numAbonne.equals("")) && (!idInterne.equals(""))) {
            abonnes = userService.getUtilisateursByNumAbonne(numAbonne);
            if (abonnes.size() == 1) {
                createEmpruntBean.setAbonneId(abonnes.get(0).getId());
                createEmpruntBean.setNumAbonne(abonnes.get(0).getNumAbonne());
                createEmpruntBean.setPrenom(abonnes.get(0).getPrenom());
                createEmpruntBean.setNom(abonnes.get(0).getNom());
                createEmpruntBean.setNumTelephone(abonnes.get(0).getNumTelephone());
                theModel.addObject("createEmpruntBean", createEmpruntBean);
            } else {
                message = "Il y a plusieurs abonnés correspondants à votre choix";
                theModel.addObject("abonnes", abonnes);
            }
            ouvrages = ouvrageService.getOuvragesByIdInterne(idInterne);
            if (ouvrages.size() == 1) {
                createEmpruntBean.setOuvrageId(ouvrages.get(0).getId());
                createEmpruntBean.setIdInterne(ouvrages.get(0).getIdInterne());
                createEmpruntBean.setTitre(ouvrages.get(0).getTitre());
                createEmpruntBean.setAuteur(ouvrages.get(0).getAuteur());
                theModel.addObject("createEmpruntBean", createEmpruntBean);
            } else {
                for (OuvrageResponseModelBean ouvrage : ouvrages) {
                    if (ouvrage.getBibliothequeId().equals(bibliothequeId)) {
                        ouvragesByBibliotheque.add(ouvrage);
                    }
                }
                message = "Il y a plusieurs ouvrages correspondants à votre choix";
                theModel.addObject("ouvrages", ouvragesByBibliotheque);
            }
        } else if (!numAbonne.equals("")) {
            abonneSelectionne = userService.getUtilisateurByNumAbonné(numAbonne);
            createEmpruntBean.setAbonneId(abonneSelectionne.getId());
            createEmpruntBean.setNumAbonne(abonneSelectionne.getNumAbonne());
            createEmpruntBean.setPrenom(abonneSelectionne.getPrenom());
            createEmpruntBean.setNom(abonneSelectionne.getNom());
            createEmpruntBean.setNumTelephone(abonneSelectionne.getNumTelephone());
            theModel.addObject("createEmpruntBean", createEmpruntBean);
        } else if (!idInterne.equals("")) {
            ouvrageSelectionne = ouvrageService.getOuvrageByIdInterne(idInterne);
            createEmpruntBean.setOuvrageId(ouvrageSelectionne.getId());
            createEmpruntBean.setIdInterne(ouvrageSelectionne.getIdInterne());
            createEmpruntBean.setTitre(ouvrageSelectionne.getTitre());
            createEmpruntBean.setAuteur(ouvrageSelectionne.getAuteur());
            theModel.addObject("createEmpruntBean", createEmpruntBean);
        }

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
        List<OuvrageResponseModelBean> ouvragesByBibliotheque = new ArrayList<>();
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
                for (OuvrageResponseModelBean ouvrage : ouvrages) {
                    if (ouvrage.getBibliothequeId().equals(bibliothequeId)) {
                        ouvragesByBibliotheque.add(ouvrage);
                    }
                }
                message = "Il y a plusieurs ouvrages correspondants à votre choix";
                theModel.addObject("ouvrages", ouvragesByBibliotheque);
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
        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        PretBean pretBean = empruntService.createEmprunt(createEmpruntBean);
        return theModel;
    }

    @GetMapping("/searchEmpruntsEnCours")
    public ModelAndView getEmpruntEnCours(@RequestParam("bibliothequeId") Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("emprunt-en-cours-page");
        String message = "";
        List<EmpruntModelBean> empruntModelBeans = new ArrayList<>();
        Date dateRetourPrévu;
        if (bibliothequeId != null) {
            BibliothequeBean bibliotheque = bibliothequeService.getBibliothequeById(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        List<PretBean> empruntsEnCours = empruntService.getEmpruntsEnCours(bibliothequeId);
        if (empruntsEnCours.isEmpty()) {
            message = "Aucun emprunt en cours pour " + (bibliothequeService.getBibliothequeById(bibliothequeId)).getNom();
            theModel.addObject("message", message);
        } else {
            for (PretBean pret : empruntsEnCours) {
                EmpruntModelBean empruntModelBean = new EmpruntModelBean();
                UtilisateurBean abonne = userService.getUtilisateurById(pret.getUtilisateurId());
                empruntModelBean.setAbonne(abonne.getPrenom() + " " + abonne.getNom());
                empruntModelBean.setAbonneId(abonne.getId());
                OuvrageResponseModelBean ouvrage = ouvrageService.getOuvrageById(pret.getOuvrageId());
                empruntModelBean.setIdentifiantOuvrage(ouvrage.getIdInterne());
                empruntModelBean.setTitreDuLivre(ouvrage.getTitre());
                empruntModelBean.setEmpruntId(pret.getId());
                empruntModelBean.setDateEmprunt(pret.getDateEmprunt());
                if (pret.isProlongation()) {
                    dateRetourPrévu = pret.getDateProlongation();
                } else {
                    dateRetourPrévu = pret.getDateRestitution();
                }
                empruntModelBean.setDateRetourPrevu(dateRetourPrévu);
                empruntModelBean.setProlongation(pret.isProlongation());
                empruntModelBeans.add(empruntModelBean);
            }
            theModel.addObject("empruntEnCours", empruntModelBeans);
        }
        return theModel;
    }

}
