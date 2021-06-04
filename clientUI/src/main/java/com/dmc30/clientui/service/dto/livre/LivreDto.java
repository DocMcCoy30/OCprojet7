package com.dmc30.clientui.service.dto.livre;

import com.dmc30.clientui.service.dto.bibliotheque.OuvrageDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class LivreDto {

    private Long id;
    private String titre;
    private String resume;
    private List<AuteurDto> auteurs;
    private EditeurDto editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueDto langue;
    private List<GenreDto> genres;
    private List<IllustrationDto> illustrations;
    private List<OuvrageDto> ouvrages;
}

