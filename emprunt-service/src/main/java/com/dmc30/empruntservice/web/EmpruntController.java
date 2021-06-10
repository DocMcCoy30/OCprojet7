package com.dmc30.empruntservice.web;

import com.dmc30.empruntservice.dto.PretDto;
import com.dmc30.empruntservice.service.contract.EmpruntService;
import com.dmc30.empruntservice.dto.CreateEmpruntDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
