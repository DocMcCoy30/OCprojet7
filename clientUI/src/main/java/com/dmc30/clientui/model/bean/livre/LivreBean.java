package com.dmc30.clientui.model.bean.livre;

import com.dmc30.clientui.model.bean.bibliotheque.OuvrageBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class LivreBean {

    private int id;
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

