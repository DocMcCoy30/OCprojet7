package com.dmc30.livreservice.shared.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

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
