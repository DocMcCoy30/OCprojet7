package com.dmc30.livreservice.shared.bibliotheque;

import com.dmc30.livreservice.shared.commun.AdresseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BibliothequeDto {

    private Long id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseDto adresse;
    private Set<OuvrageDto> ouvrages;


}
