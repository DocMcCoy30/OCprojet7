package com.dmc30.emailservice.service.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LivreBean {

    private Long id;
    private String titre;
    private String resume;
    private String dateEdition;
    private String numeroIsbn13;
    @JsonIgnore
    private String editeur;
    @JsonIgnore
    private String langue;
    @JsonIgnore
    private List<String> auteurs;
    @JsonIgnore
    private List<String> genres;
    @JsonIgnore
    private List<String> illustrations;
    private List<OuvrageBean> ouvrages;
}
