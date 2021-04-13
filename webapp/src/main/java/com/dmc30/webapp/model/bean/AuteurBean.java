package com.dmc30.webapp.model.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AuteurBean {

    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Date dateDeces;
    @JsonIgnore
    private List<LivreBean> livres;
}
