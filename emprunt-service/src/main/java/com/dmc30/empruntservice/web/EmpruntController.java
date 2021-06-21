package com.dmc30.empruntservice.web;

import com.dmc30.empruntservice.service.dto.PretDto;
import com.dmc30.empruntservice.service.contract.EmpruntService;
import com.dmc30.empruntservice.service.dto.CreateEmpruntDto;
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

    @GetMapping("/prolongation")
    public void prolongerEmprunt(@RequestParam Long empruntId) {
        empruntService.prolongerEmprunt(empruntId);
    }

    @GetMapping("/expired")
    List<PretDto> findExpiredPrets() {
        return empruntService.findExpiredPrets();
    }

    @GetMapping("/expiredByUtilisateur")
    List<PretDto> findExpiredPretsByUtilisateurId(@RequestParam Long utilisateurId) {
        List<PretDto> pretDtos = empruntService.findExpiredPretsByUtilisateurId(utilisateurId);
        System.out.println(pretDtos.toString());
        return pretDtos;
    }

    @GetMapping("/expiredUsers")
    List<Long> findUtilisateurEnRetard() {
        return empruntService.findUtilisateurEnRetard();
    }
}
