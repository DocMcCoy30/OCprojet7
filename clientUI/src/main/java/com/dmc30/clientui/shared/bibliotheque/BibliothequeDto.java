package com.dmc30.clientui.shared.bibliotheque;

import com.dmc30.clientui.shared.commun.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BibliothequeDto {

    private String code;
    private String numSiret;
    private String nom;
    private AdresseDto adresse;
    private List<OuvrageDto> ouvrages;
}
