package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.service.contract.LivreService;
import com.dmc30.clientui.service.contract.UserService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        this.bibliothequeService=bibliothequeService;
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
    public ModelAndView showIndex(@RequestParam(value = "publicId", required = false) String publicId) {
        UtilisateurDto abonneDto = new UtilisateurDto();
        ModelAndView theModel = new ModelAndView("index");
        List<BibliothequeDto> bibliotheques = bibliothequeService.getBibliotheques();
        theModel.addObject("bibliotheques", bibliotheques);
        if (publicId != null) {
            abonneDto = userService.getUtilisateurByPublicId(publicId);
            theModel.addObject("abonne", abonneDto);
        }
        return theModel;
    }


    @PostMapping("/showAccueil")
    public ModelAndView getToLast12(@RequestParam(value = "publicId", required = false) String publicId,
                              @RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {

        ModelAndView theModel = new ModelAndView("accueil");
        if (publicId != null) {
            UtilisateurDto abonne = userService.getUtilisateurByPublicId(publicId);
            theModel.addObject("abonne", abonne);
        }
        List<LivreDto> livres = livreService.get12LastLivres();
        theModel.addObject("lastLivres", livres);
        BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
        theModel.addObject("bibliotheque", bibliotheque);

        return theModel;
    }
}
