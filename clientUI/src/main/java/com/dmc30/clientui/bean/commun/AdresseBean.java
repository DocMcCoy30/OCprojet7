package com.dmc30.clientui.bean.commun;

import lombok.*;

@Getter
@Setter
public class AdresseBean {

    private String rue;
    private String codePostal;
    private String ville;
    private PaysBean pays;
}
