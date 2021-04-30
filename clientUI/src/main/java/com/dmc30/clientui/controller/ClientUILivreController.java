package com.dmc30.clientui.controller;

import com.dmc30.clientui.model.bean.livre.LivreBean;
import com.dmc30.clientui.service.ClientUILivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientUILivreController {

    ClientUILivreService livreService;

    @Autowired
    public ClientUILivreController(ClientUILivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/showLivres")
    public String getLivres(Model theModel) {
        List<LivreBean> livres = livreService.getLivres();
        theModel.addAttribute("livres", livres);
        return "accueil";
    }

    @PostMapping("/showLivresByTitre")
    public String getLivreByTitre (Model theModel,
                                   @RequestParam("motCle") String motCle) {
        List<LivreBean> livres = livreService.getLivreByTitre(motCle);
        theModel.addAttribute("livresParTitre", livres);
        return "index";
    }


}
