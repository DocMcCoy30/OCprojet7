package com.dmc30.webapp.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class LivreBean {

    private int id;
    private String titre;
    private String resume;
    private String dateEdition;
    private String numeroIsbn13;
    private List<AuteurBean> auteurs;
}

