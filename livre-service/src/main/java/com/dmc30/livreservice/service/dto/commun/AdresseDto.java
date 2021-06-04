package com.dmc30.livreservice.service.dto.commun;

import lombok.*;

@Getter
@Setter
public class AdresseDto {

    private String rue;
    private String codePostal;
    private String ville;
    private PaysDto pays;
}
