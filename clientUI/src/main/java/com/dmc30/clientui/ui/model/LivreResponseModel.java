package com.dmc30.clientui.ui.model;

import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;
import com.dmc30.clientui.shared.livre.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class LivreResponseModel {

    private String titre;
    private String resume;
    private String auteurs;
    private EditeurDto editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueDto langue;
    private List<GenreDto> genres;
    private List<IllustrationDto> illustrations;
    private Set<OuvrageDto> ouvrages;
}
