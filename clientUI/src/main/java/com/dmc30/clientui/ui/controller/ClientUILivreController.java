package com.dmc30.clientui.ui.controller;

import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.service.contract.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientUILivreController {

    LivreService livreService;

    @Autowired
    public ClientUILivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/showLivres")
    public String getLivres(Model theModel) {
        List<LivreDto> livres = livreService.getLivres();
        theModel.addAttribute("livres", livres);
        return "accueil";
    }

    @PostMapping("/showLivresByTitre")
    public String getLivreByTitre (Model theModel,
                                   @RequestParam("motCle") String motCle) {
        List<LivreDto> livres = livreService.getLivreByTitre(motCle);
        theModel.addAttribute("livresParTitre", livres);
        return "index";
    }


}
