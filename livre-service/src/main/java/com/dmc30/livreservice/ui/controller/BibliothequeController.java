package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;
import com.dmc30.livreservice.service.contract.BibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BibliothequeController {

    BibliothequeService bibliothequeService;

    @Autowired
    public BibliothequeController(BibliothequeService bibliothequeService) {
        this.bibliothequeService = bibliothequeService;
    }

    @GetMapping("/bibliotheques")
    public List<Bibliotheque> getBibliotheques() {
        return bibliothequeService.findAll();
    }

    @PostMapping("/bibliotheque")
    public Bibliotheque getBibliotheque(@RequestParam(value = "bibliothequeId", required = false) Long bibliothequeId) {
        return bibliothequeService.findById(bibliothequeId);
    }
}
