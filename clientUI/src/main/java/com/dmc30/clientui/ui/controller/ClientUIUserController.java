package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.exception.TechnicalException;
import com.dmc30.clientui.security.PasswordEncoderHelper;
import com.dmc30.clientui.shared.utilisateur.UsersDto;
import com.dmc30.clientui.shared.utilisateur.LoginRequestDto;
import com.dmc30.clientui.service.contract.ClientUIUserService;
import com.dmc30.clientui.ui.model.CreateAbonneRequestModel;
import com.dmc30.clientui.ui.model.CreateAbonneResponseModel;
import com.dmc30.clientui.ui.model.LoginRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
public class ClientUIUserController {

    Logger logger = LoggerFactory.getLogger(ClientUIUserController.class);

    private ClientUIUserService userService;
    private PasswordEncoderHelper passwordEncoderHelper;

    @Autowired
    public ClientUIUserController(ClientUIUserService userService, PasswordEncoderHelper passwordEncoderHelper) {
        this.userService = userService;
        this.passwordEncoderHelper = passwordEncoderHelper;
    }

    @GetMapping(path = "/check")
    public String status(Model theModel) {
        String message = userService.check();
        theModel.addAttribute("statut", message);
        return "accueil";
    }

    @GetMapping(path = "/login")
    public String loginPage(Model theModel) {
        LoginRequestDto user = new LoginRequestDto();
        theModel.addAttribute("user", user);
        return "login-page";
    }

//    @PostMapping(path = "/login")
//    public String login(@ModelAttribute UserDetailsDto user, Model theModel) {
//        String authenticationMessage = userService.login(user);
//        theModel.addAttribute("message", authenticationMessage);
//        return "accueil";
//    }

    @PostMapping(path = "/login")
    public ModelAndView secureLogin(@ModelAttribute LoginRequestModel userLoginDetails, ModelAndView theModel) throws TechnicalException {
        UsersDto abonneDto = new UsersDto();
        String errorMessage = "";
        String viewName = "login-page";
        try {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            LoginRequestDto loginRequestDto = modelMapper.map(userLoginDetails, LoginRequestDto.class);
            String[] result = userService.secureLogin(loginRequestDto);
            switch (result[0]) {
                case "OK":
                    abonneDto = userService.getAbonneByPublicId(result[1]);
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
        theModel.setViewName(viewName);
        return theModel;
    }

    @GetMapping(path = "/signin")
    public String signinPage(Model theModel) {
        CreateAbonneRequestModel abonne = new CreateAbonneRequestModel();
        theModel.addAttribute("abonne", abonne);
        return "signin-page";
    }

//    @PostMapping("/signin")
//    public String signin(@ModelAttribute AbonneDto abonne, @RequestParam("paysId") Long paysId, Model theModel) {
//        String signinMessage = userService.signin(abonne, paysId);
//        theModel.addAttribute("message", signinMessage);
//        return "accueil";
//    }

    @PostMapping("/signin")
    public String createAbonne(@ModelAttribute CreateAbonneRequestModel userDetails,
                               @RequestParam("paysId") Long paysId,
                               Model theModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto abonne = modelMapper.map(userDetails, UsersDto.class);
        abonne.setEncryptedPassword(passwordEncoderHelper.encodePwd(userDetails.getPassword()));
        ResponseEntity<CreateAbonneResponseModel> response = userService.createAbonne(abonne, paysId);
        logger.info("CreAbResMod : " + Objects.requireNonNull(response.getBody()).toString(), response.getStatusCode());
        String message = "L'abonné " + response.getBody().getUsername() + " / " + response.getBody().getEmail() + " a bien été enregistré.";
        theModel.addAttribute("message", message);
        return "accueil";
    }
}
