package com.dmc30.empruntservice.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmpruntDto {

    private Long abonneId;
    private String numAbonne;
    private String prenom;
    private String nom;
    private String numTelephone;
    private Long ouvrageId;
    private String idInterne;
    private String titre;
    private String auteur;
}
