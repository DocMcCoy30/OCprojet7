package com.dmc30.clientui.ui.model;

import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;
import com.dmc30.clientui.shared.livre.EditeurDto;
import com.dmc30.clientui.shared.livre.GenreDto;
import com.dmc30.clientui.shared.livre.IllustrationDto;
import com.dmc30.clientui.shared.livre.LangueDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivreResponseModel {

    private Long id;
    private String titre;
    private String resume;
    private String auteurs;
    private EditeurDto editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueDto langue;
    private List<GenreDto> genres;
    private List<IllustrationDto> illustrations;
    private List<OuvrageDto> ouvrages;
}
