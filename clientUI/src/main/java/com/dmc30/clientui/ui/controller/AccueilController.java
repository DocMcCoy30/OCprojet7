package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AccueilController {

    UserService userService;
    LivreService livreService;

    @Autowired
    public AccueilController(UserService userService, LivreService livreService) {
        this.userService = userService;
        this.livreService=livreService;
    }

    Logger logger = LoggerFactory.getLogger(AccueilController.class);

//    @GetMapping("/")
//    public String getToAccueil(@RequestParam(value = "publicId", required = false) String publicId, Model theModel) {
//        if (publicId!=null) {
//            UtilisateurDto abonne = userService.getUtilisateurByPublicId(publicId);
//            theModel.addAttribute("abonne", abonne);
//        }
//        LivreDto livre = new LivreDto();
//        theModel.addAttribute("livre", livre);
//        return "accueil";
//    }

    @GetMapping("/")
    public String getToLast12(@RequestParam(value = "publicId", required = false) String publicId, Model theModel) {
        if (publicId!=null) {
            UtilisateurDto abonne = userService.getUtilisateurByPublicId(publicId);
            theModel.addAttribute("abonne", abonne);
        }
        List<LivreDto> livres = livreService.get12LastLivres();
        theModel.addAttribute("lastLivres", livres);
        return "accueil";
    }
}
