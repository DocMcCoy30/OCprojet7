package com.dmc30.clientui.shared.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AuteurDto {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;
    private List<LivreDto> livres;
}
