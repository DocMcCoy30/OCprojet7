package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.exception.TechnicalException;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * A terme, connecte l'interface utilisateur (Front) avec le microservice User (user-service) via la couche service et proxy.
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final BibliothequeService bibliothequeService;
    private final PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public UserController(UserService userService, BibliothequeService bibliothequeService, PasswordEncoderHelper passwordEncoderHelper) {
        this.userService = userService;
        this.bibliothequeService = bibliothequeService;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    /**
     * méthode test - affiche la page accueil.
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
     * @param logout si présent, deconnecte l'utilisateur.
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     * @return la vue login-page avec un objet LoginRequest (identifiant/mot de passe) ou la page index avec la liste des bibliothèque en cas de deconnexion.
     */
    @GetMapping(path = "/login")
    public ModelAndView loginPage(@RequestParam(value = "logout", required = false) String logout,
                                  @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("login-page");
        LoginRequestDto user = new LoginRequestDto();
        if (logout != null) {
            List<BibliothequeDto> bibliotheques = bibliothequeService.getBibliotheques();
            theModel.addObject("bibliotheques", bibliotheques);
            theModel.addObject("logoutMessage", "Vous êtes deconnecté !");
            theModel.setViewName("index");
        }
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        theModel.addObject("user", user);
        return theModel;
    }

    /**
     * Traitement des données pour identification et connexion sécurisée de l'utilisateur (SpringSecurity)
     * @param userLoginDetails Les identifiants/mot de passe de l'utilisateur entrés sur la page login-page
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @param theModel Le Model renvoyé.
     * @return la vue accueil si l'identification est un succès, la page login avec un messge d'erreur si les identifiant/mot de passe renseignés sont erronés.
     * @throws TechnicalException
     */
    @PostMapping(path = "/login")
    public ModelAndView secureLogin(@ModelAttribute LoginRequestModel userLoginDetails,
                                    @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                                    ModelAndView theModel) throws TechnicalException {
        UtilisateurDto abonneDto = new UtilisateurDto();
        String errorMessage = "";
        String viewName = "login-page";
        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            LoginRequestDto loginRequestDto = modelMapper.map(userLoginDetails, LoginRequestDto.class);
            String[] result = userService.secureLogin(loginRequestDto);
            switch (result[0]) {
                case "OK":
                    abonneDto = userService.getUtilisateurByPublicId(result[1]);
                    theModel.addObject("abonne", abonneDto);
                    viewName = "accueil";
                    break;
                case "KO":
                    errorMessage = result[1];
                    theModel.addObject("errorMessage", errorMessage);
                    theModel.addObject("user", new LoginRequestModel());
            }
        } catch (TechnicalException e) {
            errorMessage = e.getMessage();
            theModel.addObject("errorMessage", errorMessage);
        }
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        theModel.setViewName(viewName);
        return theModel;
    }

    /**
     * Affiche la page signin-page permettant à l'utilisateur de renseigner ses données personnelles afin de créer un compte (abonné)
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @param theModel Le Model renvoyé.
     * @return la vue signin-page avec la bibliothèque selectionnée.
     */
    @GetMapping(path = "/signin")
    public String signinPage(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                             Model theModel) {
        UtilisateurDto abonne = new UtilisateurDto();
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addAttribute("bibliotheque", bibliotheque);
        }
        theModel.addAttribute("abonne", abonne);
        return "signin-page";
    }

    /**
     * Traitement des données pour création d'un compte abonné avec cryptage du mot de passe.
     * @param userDetails Les données personnelles de l'utilisateur nécessaire à la création d'un compte abonné.
     * @param paysId L'identifiant du pays de résidence selectionné.
     * @param bibliothequeId L'identifiant de la bibliothèque selectionnée.
     * @param theModel le Model renvoyé.
     * @return La page accueil avec la bibliothèque selectionnée et un message e confirmation de la création du compte.
     */
    @PostMapping("/signin")
    public String createAbonne(@ModelAttribute UtilisateurDto userDetails,
                               @RequestParam("paysId") Long paysId,
                               @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                               Model theModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UtilisateurDto abonne = modelMapper.map(userDetails, UtilisateurDto.class);
        abonne.setEncryptedPassword(passwordEncoderHelper.encodePwd(userDetails.getPassword()));
        ResponseEntity<CreateAbonneResponseModel> response = userService.createAbonne(abonne, paysId);
        String message = "L'abonné " + response.getBody().getUsername() + " / " + response.getBody().getEmail() + " a bien été enregistré.";
        theModel.addAttribute("message", message);
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addAttribute("bibliotheque", bibliotheque);
        }
        return "accueil";
    }

    /**
     * affiche la page profil de l'utilisateur pour consultation et modification de ses données personnelles
     * @param publicId L'identifiant public de l'utilisateur connecté.
     * @param bibliothequeId L'identiant de la bibliothèque selectionnées
     * @return la vue profil-utilisateur avec la bibliothèque selectionnée, et le détail des données de l'utilisateur connecté.
     */
    @GetMapping(value = "/showProfil")
    public ModelAndView showProfil(@RequestParam("publicId") String publicId,
                                   @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        ModelAndView theModel = new ModelAndView("profil-utilisateur");
        UtilisateurDto abonne = userService.getUtilisateurByPublicId(publicId);
        theModel.addObject("abonne", abonne);
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        return theModel;
    }
}
