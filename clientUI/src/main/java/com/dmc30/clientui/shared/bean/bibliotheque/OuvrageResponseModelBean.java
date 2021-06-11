package com.dmc30.clientui.shared.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuvrageResponseModelBean {

    Long id;
    String idInterne;
    String titre;
    String auteur;
    Boolean emprunte;
    Long bibliothequeId;
}
