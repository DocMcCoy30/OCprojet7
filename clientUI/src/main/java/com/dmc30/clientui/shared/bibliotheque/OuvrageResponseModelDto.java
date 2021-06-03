package com.dmc30.clientui.shared.bibliotheque;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuvrageResponseModelDto {

    Long id;
    String idInterne;
    String titre;
    String auteur;
}
