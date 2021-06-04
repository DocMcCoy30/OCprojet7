package com.dmc30.clientui.bean.livre;

import com.dmc30.clientui.bean.bibliotheque.OuvrageBean;
import com.dmc30.clientui.bean.livre.EditeurBean;
import com.dmc30.clientui.bean.livre.GenreBean;
import com.dmc30.clientui.bean.livre.IllustrationBean;
import com.dmc30.clientui.bean.livre.LangueBean;
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
    private List<GenreBean> genres;
    private List<IllustrationBean> illustrations;
    private List<OuvrageBean> ouvrages;
}
