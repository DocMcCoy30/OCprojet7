package com.dmc30.clientui.model.dto.livre;

import com.dmc30.clientui.model.dto.bibliotheque.OuvrageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class LivreDto {

    private int id;
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

