package com.dmc30.clientui.shared.bibliotheque;

import com.dmc30.clientui.shared.commun.AdresseDto;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@EqualsAndHashCode(exclude = {"ouvrages"})
//@ToString(exclude = {"ouvrages"})
public class BibliothequeDto {

    private Long id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseDto adresse;
    private Set<OuvrageDto> ouvrages;



}
