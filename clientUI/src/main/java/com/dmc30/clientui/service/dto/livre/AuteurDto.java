package com.dmc30.clientui.service.dto.livre;

import lombok.*;

@Getter
@Setter
public class AuteurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;

}
