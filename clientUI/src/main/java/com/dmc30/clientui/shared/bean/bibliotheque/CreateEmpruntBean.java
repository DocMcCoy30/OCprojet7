package com.dmc30.clientui.shared.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmpruntBean {

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
