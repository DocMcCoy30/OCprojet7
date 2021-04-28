package com.dmc30.clientui.model.bean.livre;

import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

public class GenreBean {

    private int id;
    private String genre;
    @JsonIgnore
    private List<LivreBean> livres;
}
