package com.dmc30.clientui.shared.livre;

import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;
import lombok.*;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivreDto {

    private String titre;
    private String resume;
    private List<AuteurDto> auteurs;
    private EditeurDto editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueDto langue;
    private List<GenreDto> genres;
    private List<IllustrationDto> illustrations;
    private Set<OuvrageDto> ouvrages;
}

