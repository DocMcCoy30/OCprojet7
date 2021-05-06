package com.dmc30.clientui.model.dto.commun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AdresseDto {

    private int id;
    private String rue;
    private String codePostal;
    private String ville;
    private PaysDto pays;
}
