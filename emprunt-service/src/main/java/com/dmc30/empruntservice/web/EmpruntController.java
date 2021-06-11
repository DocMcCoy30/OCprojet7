package com.dmc30.empruntservice.web;

import com.dmc30.empruntservice.dto.PretDto;
import com.dmc30.empruntservice.service.contract.EmpruntService;
import com.dmc30.empruntservice.dto.CreateEmpruntDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprunts")
public class EmpruntController {

    EmpruntService empruntService;

    @Autowired
    public EmpruntController(EmpruntService empruntService) {
        this.empruntService = empruntService;
    }

    @PostMapping("/create")
    public PretDto createEmprunt(@RequestBody CreateEmpruntDto createEmpruntDto) {
        PretDto pretDto = empruntService.createEmprunt(createEmpruntDto);
        return pretDto;
    }

    @GetMapping("/encours")
    public List<PretDto> findEmpruntEnCours(@RequestParam Long bibliothequeId) {
        List<PretDto> pretDtoList = empruntService.findEmpruntEnCours(bibliothequeId);
        return pretDtoList;
    }

    @GetMapping("/utilisateur")
    public List<PretDto> findEmpruntByUtilisateurId (@RequestParam Long utilisateurId) {
        List<PretDto> pretDtoList = empruntService.findEmpruntByUtilisateurId(utilisateurId);
        return pretDtoList;
    }

    @GetMapping("/retour")
    public void retournerEmprunt(@RequestParam Long empruntId, @RequestParam String ouvrageId) {
        empruntService.retournerEmprunt(empruntId, ouvrageId);
    }
}
