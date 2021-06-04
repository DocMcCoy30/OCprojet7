package com.dmc30.clientui.web.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.service.dto.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.service.dto.bibliotheque.CreateEmpruntDto;
import com.dmc30.clientui.service.dto.bibliotheque.OuvrageResponseModelDto;
import com.dmc30.clientui.service.dto.utilisateur.UtilisateurDto;
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

    @Autowired
    public EmpruntController(BibliothequeService bibliothequeService, UserService userService, OuvrageService ouvrageService) {
        this.bibliothequeService = bibliothequeService;
        this.userService = userService;
        this.ouvrageService = ouvrageService;
    }

    @GetMapping("/showEmpruntPage")
    public ModelAndView showEmpruntPage(@RequestParam("bibliothequeId") Long bibliothequeId,
                                        @ModelAttribute CreateEmpruntDto createEmpruntDto,
                                        @RequestParam(value = "numAbonne", required = false) String numAbonne,
                                        @RequestParam(value = "idInterne", required = false) String idInterne) {

        ModelAndView theModel = new ModelAndView("emprunt-page");
        UtilisateurDto abonneSelectionne = new UtilisateurDto();
        OuvrageResponseModelDto ouvrageSelectionne = new OuvrageResponseModelDto();
        createEmpruntDto = new CreateEmpruntDto();
        List<UtilisateurDto> abonnes = new ArrayList<>();
        List<OuvrageResponseModelDto> ouvrages = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        if (numAbonne == null) numAbonne = "";
        if (idInterne == null) idInterne = "";

        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        if ((!numAbonne.equals("")) && (!idInterne.equals(""))) {
            abonneSelectionne = userService.getUtilisateurByNumAbonné(numAbonne);
            ouvrageSelectionne = ouvrageService.getOuvrageByIdInterne(idInterne);
            createEmpruntDto.setAbonneId(abonneSelectionne.getId());
            createEmpruntDto.setNumAbonne(abonneSelectionne.getNumAbonne());
            createEmpruntDto.setPrenom(abonneSelectionne.getPrenom());
            createEmpruntDto.setNom(abonneSelectionne.getNom());
            createEmpruntDto.setNumTelephone(abonneSelectionne.getNumTelephone());
            createEmpruntDto.setOuvrageId(ouvrageSelectionne.getId());
            createEmpruntDto.setIdInterne(ouvrageSelectionne.getIdInterne());
            createEmpruntDto.setTitre(ouvrageSelectionne.getTitre());
            createEmpruntDto.setAuteur(ouvrageSelectionne.getAuteur());
        } else if (!numAbonne.equals("")) {
            abonneSelectionne = userService.getUtilisateurByNumAbonné(numAbonne);
            createEmpruntDto.setAbonneId(abonneSelectionne.getId());
            createEmpruntDto.setNumAbonne(abonneSelectionne.getNumAbonne());
            createEmpruntDto.setPrenom(abonneSelectionne.getPrenom());
            createEmpruntDto.setNom(abonneSelectionne.getNom());
            createEmpruntDto.setNumTelephone(abonneSelectionne.getNumTelephone());
        } else if (!idInterne.equals("")) {
            ouvrageSelectionne = ouvrageService.getOuvrageByIdInterne(idInterne);
            createEmpruntDto.setOuvrageId(ouvrageSelectionne.getId());
            createEmpruntDto.setIdInterne(ouvrageSelectionne.getIdInterne());
            createEmpruntDto.setTitre(ouvrageSelectionne.getTitre());
            createEmpruntDto.setAuteur(ouvrageSelectionne.getAuteur());
        }
        theModel.addObject("createEmpruntDto", createEmpruntDto);
        return theModel;
    }

    @PostMapping("/createEmpruntSearchForm")
    public ModelAndView populateTheCreateEmpruntForm(@RequestParam("bibliothequeId") Long bibliothequeId,
                                                     @ModelAttribute CreateEmpruntDto createEmpruntDto,
                                                     @RequestParam(value = "numAbonne", required = false) String numAbonne,
                                                     @RequestParam(value = "idInterne", required = false) String idInterne) {

        ModelAndView theModel = new ModelAndView("emprunt-page");
        List<UtilisateurDto> abonnes = new ArrayList<>();
        List<OuvrageResponseModelDto> ouvrages = new ArrayList<>();
        theModel.addObject("abonnes", abonnes);
        theModel.addObject("ouvrages", ouvrages);
        String message = "";

        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        if ((numAbonne.equals("")) && (idInterne.equals(""))) {
            message = "Aucuns critères renseignés pour la recherche.";
        }
        if ((numAbonne != null) && (!numAbonne.equals(""))) {
            abonnes = userService.getUtilisateursByNumAbonne(createEmpruntDto.getNumAbonne());
            if (abonnes.size() == 1) {
                createEmpruntDto.setAbonneId(abonnes.get(0).getId());
                createEmpruntDto.setNumAbonne(abonnes.get(0).getNumAbonne());
                createEmpruntDto.setPrenom(abonnes.get(0).getPrenom());
                createEmpruntDto.setNom(abonnes.get(0).getNom());
                createEmpruntDto.setNumTelephone(abonnes.get(0).getNumTelephone());
            } else {
                message = "Il y a plusieurs abonnés correspondants à votre choix";
                theModel.addObject("abonnes", abonnes);
            }

        }
        if ((idInterne != null) && (!idInterne.equals(""))) {
            ouvrages = ouvrageService.getOuvragesByIdInterne(createEmpruntDto.getIdInterne());
            if (ouvrages.size() == 1) {
                createEmpruntDto.setOuvrageId(ouvrages.get(0).getId());
                createEmpruntDto.setIdInterne(ouvrages.get(0).getIdInterne());
                createEmpruntDto.setTitre(ouvrages.get(0).getTitre());
                createEmpruntDto.setAuteur(ouvrages.get(0).getAuteur());
            } else {
                message = "Il y a plusieurs ouvrages correspondants à votre choix";
                theModel.addObject("ouvrages", ouvrages);
            }
            theModel.addObject("createEmpruntDto", createEmpruntDto);
        }
        theModel.addObject("message", message);
        return theModel;
    }

}
