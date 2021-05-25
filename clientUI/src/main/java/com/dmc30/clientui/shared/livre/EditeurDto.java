package com.dmc30.clientui.shared.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class EditeurDto {

    private String nomMaisonEdition;
    private List<LivreDto> livres;

}
