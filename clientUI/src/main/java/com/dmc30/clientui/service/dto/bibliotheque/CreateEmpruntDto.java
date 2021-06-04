package com.dmc30.clientui.service.dto.bibliotheque;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmpruntDto {

    Long abonneId;
    String numAbonne;
    String prenom;
    String nom;
    String numTelephone;
    Long ouvrageId;
    String idInterne;
    String titre;
    String auteur;
}
