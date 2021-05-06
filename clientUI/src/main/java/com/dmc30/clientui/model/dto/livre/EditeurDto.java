package com.dmc30.clientui.model.dto.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EditeurDto {

    private int id;
    private String nomMaisonEdition;
    private List<LivreDto> livres;
}
