package com.dmc30.emailservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMailDto {

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private List<LivreForMailDto> livres;
}
