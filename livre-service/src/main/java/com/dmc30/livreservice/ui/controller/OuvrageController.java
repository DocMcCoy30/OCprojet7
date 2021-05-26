package com.dmc30.livreservice.ui.controller;

import com.dmc30.livreservice.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OuvrageController {

    OuvrageService ouvrageService;

    @Autowired
    public OuvrageController(OuvrageService ouvrageService) {
        this.ouvrageService = ouvrageService;
    }

    @GetMapping("/ouvrageDispoInOne")
    public Integer getOuvrageDispoInOneBibliotheque(@RequestParam("livreId") Long livreId,
                                                    @RequestParam("bibliothequeId") Long bibliothequeId) {
        return ouvrageService.findOuvrageDispoInOneBibliotheque(livreId,bibliothequeId);
    }

    @GetMapping("/ouvrageDispoInOther")
    public List<Object> getOuvrageDispoInOtherBibliotheque(@RequestParam("livreId") Long livreId,
                                                            @RequestParam("bibliothequeId") Long bibliothequeId) {
        return ouvrageService.findOuvrageDispoInOtherBibiotheque(livreId,bibliothequeId);
    }

}
