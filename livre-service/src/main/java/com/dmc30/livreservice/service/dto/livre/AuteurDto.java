package com.dmc30.livreservice.service.dto.livre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuteurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;
}
