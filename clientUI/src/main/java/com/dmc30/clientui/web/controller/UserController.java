package com.dmc30.clientui.web.controller;

import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.UtilsMethodService;
import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.shared.bean.utilisateur.CreateAbonneBean;
import com.dmc30.clientui.shared.bean.utilisateur.LoginRequestBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.web.exception.TechnicalException;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * A terme, connecte l'interface utilisateur (Front) avec le microservice User (user-service) via la couche service et proxy.
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    UtilsMethodService utilsMethodService;
    UserService userService;
    BibliothequeService bibliothequeService;
    OuvrageService ouvrageService;
    EmpruntService empruntService;
    PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public UserController(UtilsMethodService utilsMethodService,
                          UserService userService,
                          BibliothequeService bibliothequeService,
                          EmpruntService empruntService,
                          OuvrageService ouvrageService,
                          PasswordEncoderHelper passwordEncoderHelper) {
        this.utilsMethodService = utilsMethodService;
        this.userService = userService;
        this.bibliothequeService = bibliothequeService;
        this.empruntService = empruntService;
        this.ouvrageService = ouvrageService;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    /**
     * méthode test - affiche la page accueil.
     *
     * @param theModel le model renvoyé.
     * @return la vue avec un message compte rendu de vérification du bon fonctionnement du service.
     */
    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message = userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }

    /**
     * Affiche la vue login-page pour que l'utilisateur renseigne ses identifiants / mot de passe ou la page index en cas de demande de déconnexion
     *
     * @param logout         si présent, deconnecte l'utilisateur.
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     * @return la vue login-page avec un objet LoginRequest (identifiant/mot de passe) ou la page index avec la liste des bibliothèque en cas de deconnexion.
     */
    @GetMapping(path = "/login")
    public ModelAndView loginPage(@RequestParam(value = "logout", required = false) String logout,
                                  @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("login-page");
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        LoginRequestBean user = new LoginRequestBean();
        if (logout != null) {
            ResponseEntity<?> bibliotheques = bibliothequeService.getBibliotheques();
            theModel.addObject("bibliotheques", bibliotheques.getBody());
            theModel.addObject("logoutMessage", "Vous êtes deconnecté !");
            theModel.setViewName("index");
        }
        theModel.addObject("user", user);
        return theModel;
    }

    /**
     * Traitement des données pour identification et connexion sécurisée de l'utilisateur (SpringSecurity)
     *
     * @param userLoginDetails Les identifiants/mot de passe de l'utilisateur entrés sur la page login-page
     * @param bibliothequeId   L'identifiant de la bibliothèque selectionnée.
     * @param theModel         Le Model renvoyé.
     * @return la vue accueil si l'identification est un succès, la page login avec un messge d'erreur si les identifiant/mot de passe renseignés sont erronés.
     * @throws TechnicalException
     */
    @PostMapping(path = "/login")
    public ModelAndView secureLogin(@ModelAttribute LoginRequestBean userLoginDetails,
                                    @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                                    ModelAndView theModel) throws TechnicalException {
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        UtilisateurBean abonneDto = new UtilisateurBean();
        String errorMessage = "";
        String viewName = "login-page";
        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            LoginRequestBean loginRequestBean = modelMapper.map(userLoginDetails, LoginRequestBean.class);
            String[] result = userService.secureLogin(loginRequestBean);
            switch (result[0]) {
                case "OK":
                    abonneDto = userService.getUtilisateurByPublicId(result[1]);
                    theModel.addObject("abonne", abonneDto);
                    viewName = "accueil";
                    break;
                case "KO":
                    errorMessage = result[1];
                    theModel.addObject("errorMessage", errorMessage);
                    theModel.addObject("user", new LoginRequestBean());
            }
        } catch (TechnicalException e) {
            errorMessage = e.getMessage();
            theModel.addObject("errorMessage", errorMessage);
        }
        theModel.setViewName(viewName);
        return theModel;
    }

    /**
     * Affiche la page signin-page permettant à l'utilisateur de renseigner ses données personnelles afin de créer un compte (abonné)
     *
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @return la vue signin-page avec la bibliothèque selectionnée.
     */
    @GetMapping(path = "/signin")
    public ModelAndView signinPage(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("signin-page");
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        CreateAbonneBean abonne = new CreateAbonneBean();
        theModel.addObject("abonne", abonne);
        return theModel;
    }

    /**
     * Traitement des données pour création d'un compte abonné avec cryptage du mot de passe.
     *
     * @param userDetails    Les données personnelles de l'utilisateur nécessaire à la création d'un compte abonné.
     * @param paysId         L'identifiant du pays de résidence selectionné.
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @return La page accueil avec la bibliothèque selectionnée et un message e confirmation de la création du compte.
     */
    @PostMapping("/signin")
    public ModelAndView createAbonne(@ModelAttribute @Valid CreateAbonneBean userDetails,
                                     BindingResult bindingResult,
                                     @RequestParam("paysId") Long paysId,
                                     @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView();
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        String message = "";
        String fieldError = "";
        String path = "";
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                logger.info(error.getObjectName() + " - " + error.getField() + " - " + error.getDefaultMessage());
                fieldError = error.getDefaultMessage();
                theModel.addObject("fieldError", fieldError);
            }
            logger.info(String.valueOf(bindingResult.getModel()));
            theModel.addObject("abonne", userDetails);

            message = "Les informations renseignées ne sont pas conformes";
            path = "signin-page";
        } else {
            UtilisateurBean createdAbonne = modelMapper.map(userDetails, UtilisateurBean.class);
            createdAbonne.setEncryptedPassword(passwordEncoderHelper.encodePwd(userDetails.getPassword()));
            createdAbonne = userService.createAbonne(createdAbonne, paysId);
            message = "L'abonné " + createdAbonne.getUsername() + " / " + createdAbonne.getEmail() + " a bien été enregistré.";
            path = "accueil";
        }
        theModel.setViewName(path);
        theModel.addObject("message", message);
        return theModel;
    }

    /**
     * affiche la page profil de l'utilisateur pour consultation et modification de ses données personnelles
     *
     * @param bibliothequeId L'identiant de la bibliothèque selectionnées
     * @return la vue profil-utilisateur avec la bibliothèque selectionnée, et le détail des données de l'utilisateur connecté.
     */
    @GetMapping(value = "/showProfil")
    public ModelAndView showProfil(@RequestParam(value = "username", required = false) String username,
                                   @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                                   @RequestParam(value = "modification", required = false) boolean modification) {
        ModelAndView theModel = new ModelAndView("profil-utilisateur");
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        String message = "";
        utilsMethodService.setEmpruntListForProfilView(username, theModel, modification);
        return theModel;
    }

    /**
     * Modification d'un profil utilisateur.
     *
     * @param userDetails    Les données personnelles de l'utilisateur à la modification d'un compte abonné.
     * @param paysId         L'identifiant du pays de résidence selectionné.
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @return La page profil avec la bibliothèque selectionnée et un message e confirmation de la modification du compte.
     */
    @PostMapping("/update")
    public ModelAndView updateAbonne(@ModelAttribute UtilisateurBean userDetails,
                                     @RequestParam(value = "paysId", required = false) Long paysId,
                                     @RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                                     @RequestParam(value = "modification", required = false) boolean modification) {
        ModelAndView theModel = new ModelAndView("profil-utilisateur");
        modification = false;
        utilsMethodService.setBibliothequeForTheVue(theModel, bibliothequeId);
        userService.updateAbonne(userDetails);
        utilsMethodService.setEmpruntListForProfilView(username, theModel, modification);

//        UtilisateurBean abonne = userService.getUtilisateurByPublicId(userDetails.getPublicId());
//        theModel.addObject("abonne", abonne);
        return theModel;
    }
}
