package com.dmc30.clientui.shared.livre;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class AuteurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;

}
