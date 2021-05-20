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
import java.util.Objects;

@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private BibliothequeService bibliothequeService;
    private PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public UserController(UserService userService, BibliothequeService bibliothequeService, PasswordEncoderHelper passwordEncoderHelper) {
        this.userService = userService;
        this.bibliothequeService = bibliothequeService;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message = userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }

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

//    @PostMapping(path = "/login")
//    public String login(@ModelAttribute LoginRequestDto user, Model theModel) {
//        String authenticationMessage = userService.login(user);
//        theModel.addAttribute("message", authenticationMessage);
//        return "accueil";
//    }

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

    @GetMapping(path = "/signin")
    public String signinPage(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId,
                             Model theModel) {
//        CreateAbonneRequestModel abonne = new CreateAbonneRequestModel();
        UtilisateurDto abonne = new UtilisateurDto();
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addAttribute("bibliotheque", bibliotheque);
        }
        theModel.addAttribute("abonne", abonne);
        return "signin-page";
    }

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
        logger.info("CreAbResMod : " + Objects.requireNonNull(response.getBody()).toString(), response.getStatusCode());
        String message = "L'abonné " + response.getBody().getUsername() + " / " + response.getBody().getEmail() + " a bien été enregistré.";
        theModel.addAttribute("message", message);
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addAttribute("bibliotheque", bibliotheque);
        }
        return "accueil";
    }

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
