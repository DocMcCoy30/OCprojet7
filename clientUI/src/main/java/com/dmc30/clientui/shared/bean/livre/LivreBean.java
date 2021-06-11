package com.dmc30.clientui.shared.bean.livre;

import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageBean;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class LivreBean {

    private Long id;
    private String titre;
    private String resume;
    private List<AuteurBean> auteurs;
    private EditeurBean editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueBean langue;
    private List<GenreBean> genres;
    private List<IllustrationBean> illustrations;
    private List<OuvrageBean> ouvrages;
}

