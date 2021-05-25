package com.dmc30.livreservice.shared.livre;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class EditeurDto {

    private String nomMaisonEdition;
    private List<LivreDto> livres;

    @Override
    public String toString() {
        return "EditeurDto{" +
                "nomMaisonEdition='" + nomMaisonEdition + '\'' +
                '}';
    }
}
