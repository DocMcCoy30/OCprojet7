package com.dmc30.livreservice.service.dto.livre;

import com.dmc30.livreservice.service.dto.bibliotheque.OuvrageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivreDto {

    private Long id;
    private String titre;
    private String resume;
    private String dateEdition;
    private String numeroIsbn13;
    private EditeurDto editeur;
    private LangueDto langue;
    private List<AuteurDto> auteurs;
    private List<GenreDto> genres;
    private List<IllustrationDto> illustrations;
    private List<OuvrageDto> ouvrages;
}
