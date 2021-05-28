package com.dmc30.livreservice.shared.bibliotheque;

import com.dmc30.livreservice.shared.commun.AdresseDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BibliothequeDto {

    private Long id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseDto adresse;
    private List<OuvrageDto> ouvrages;

}
