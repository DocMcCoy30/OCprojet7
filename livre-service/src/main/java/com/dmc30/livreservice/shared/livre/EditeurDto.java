package com.dmc30.livreservice.shared.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class EditeurDto {

    private String nomMaisonEdition;
    @JsonIgnore
    private List<LivreDto> livres;

    @Override
    public String toString() {
        return "EditeurDto{" +
                "nomMaisonEdition='" + nomMaisonEdition + '\'' +
                '}';
    }
}
