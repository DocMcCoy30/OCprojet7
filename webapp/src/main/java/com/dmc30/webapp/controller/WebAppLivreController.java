package com.dmc30.webapp.controller;

import com.dmc30.webapp.model.bean.LivreBean;
import com.dmc30.webapp.service.WebAppLivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebAppLivreController {

    WebAppLivreService livreService;

    @Autowired
    public WebAppLivreController(WebAppLivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/showLivres")
    public String getLivres(Model theModel) {
        List<LivreBean> livres = livreService.getLivres();
        theModel.addAttribute("livres", livres);
        return "index";
    }

    @PostMapping("/showLivresByTitre")
    public String getLivreByTitre (Model theModel,
                                   @RequestParam("motCle") String motCle) {
        List<LivreBean> livres = livreService.getLivreByTitre(motCle);
        theModel.addAttribute("livresParTitre", livres);
        return "index";
    }


}
