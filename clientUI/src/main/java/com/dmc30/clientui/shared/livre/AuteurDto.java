package com.dmc30.clientui.shared.livre;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Setter
public class AuteurDto {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;
    private List<LivreDto> livres;

}
