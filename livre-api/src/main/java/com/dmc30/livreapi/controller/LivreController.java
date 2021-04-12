package com.dmc30.livreapi.controller;

import com.dmc30.livreapi.model.Livre;
import com.dmc30.livreapi.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivreController {

    LivreService livreService;

    @Autowired
    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping(path = "/livres")
    public List<Livre> getLivres() {
        return livreService.findAll();
    }

    @PostMapping(path = "/livres/titre")
    public List<Livre> getLivreByMotCle(@RequestParam("motCle") String motCle) {
        return livreService.findLivreByTitreContaining(motCle);
    }
}
