package com.dmc30.clientui.shared.bean.livre;

import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageBean;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivreResponseModelBean {

    private Long id;
    private String titre;
    private String resume;
    private String auteurs;
    private EditeurBean editeur;
    private String dateEdition;
    private String numeroIsbn13;
    private LangueBean langue;
    private String genres;
    private List<IllustrationBean> illustrations;
    private List<OuvrageBean> ouvrages;
}
