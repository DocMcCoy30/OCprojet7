package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.service.contract.LivreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LivreController {

    Logger logger = LoggerFactory.getLogger(LivreController.class);

    private LivreService livreService;
    private BibliothequeService bibliothequeService;

    @Autowired
    public LivreController(LivreService livreService, BibliothequeService bibliothequeService) {
        this.livreService = livreService;
        this.bibliothequeService = bibliothequeService;
    }

    @GetMapping("/showLivres")
    public String getLivres(Model theModel) {
        List<LivreDto> livres = livreService.getLivres();
        theModel.addAttribute("livres", livres);
        return "accueil";
    }

    @PostMapping("/showLivresByTitre")
    public String getLivreByTitre(Model theModel,
                                  @RequestParam("motCle") String motCle) {
        List<LivreDto> livres = livreService.getLivreByTitre(motCle);
        theModel.addAttribute("livresParTitre", livres);
        return "accueil";
    }

    @PostMapping("/searchLivres")
    public ModelAndView searchLivres(@RequestParam(value = "search-param", required = false) Integer searchParam,
                                     @RequestParam(value = "mot-cle", required = false) String motCle,
                                     @RequestParam("bibliothequeId") Long bibliothequeId) {
        String errorMessage = null;
        ModelAndView theModel = new ModelAndView("recherche");
        List<LivreDto> livres = new ArrayList<>();
        logger.info("searchParam = " + searchParam);
        logger.info("motCle = " + motCle);
        String lowerMotCle = "";
        if (searchParam != null) {
            lowerMotCle = motCle.toLowerCase();
            switch (searchParam) {
                case 1:
                    livres = livreService.getLivreByTitre(lowerMotCle);
                    break;
                case 2:
                    livres = livreService.getLivreByAuteur(lowerMotCle);
                    break;
            }
        } else if (searchParam == null) {
            errorMessage = "Selectionnez un citère de recherche !";
        }
        if (livres.isEmpty()) {
            errorMessage = "Aucun livre trouvé pour cette recherche !";
        }
        if (bibliothequeId != null) {
            BibliothequeDto bibliotheque = bibliothequeService.getBibliotheque(bibliothequeId);
            theModel.addObject("bibliotheque", bibliotheque);
        }
        theModel.addObject("livres", livres);
        theModel.addObject("errorMessage", errorMessage);
        return theModel;
    }

    @PostMapping("/showLivresByAuteur")
    public String getLivreByAuteur(Model theModel,
                                   @RequestParam("motCle") String motCle) {
        List<LivreDto> livres = livreService.getLivreByAuteur(motCle);
        theModel.addAttribute("livresParAuteur", livres);
        return "accueil";
    }
}
