package com.dmc30.livreservice.shared.livre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class AuteurDto {

    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateDeces;
    @JsonIgnore
    private List<LivreDto> livres;

    @Override
    public String toString() {
        return "AuteurDto{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", dateDeces='" + dateDeces + '\'' +
                '}';
    }
}
