package com.dmc30.clientui.ui.model;

import lombok.Data;

@Data
public class Adresse {

    private String rue;
    private String codePostal;
    private String ville;
    private Pays pays;
}
