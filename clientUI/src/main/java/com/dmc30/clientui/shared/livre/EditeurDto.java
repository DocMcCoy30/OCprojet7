package com.dmc30.clientui.shared.livre;

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

    private String nomMaisonEdition;
    private List<LivreDto> livres;

    @Override
    public String toString() {
        return "EditeurDto{" +
                "nomMaisonEdition='" + nomMaisonEdition + '\'' +
                '}';
    }
}
