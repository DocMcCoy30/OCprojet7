package com.dmc30.userservice.ui.model;

import com.dmc30.userservice.shared.PaysDto;
import lombok.Data;

@Data
public class Adresse {

    private String rue;
    private String codePostal;
    private String ville;
    private PaysDto pays;
}
