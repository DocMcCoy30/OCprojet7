package com.dmc30.emailservice.service.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateMailBean {

    private Long userId;
    private String username;
    private String prenom;
    private String nom;
    private String email;
    private List<LivreForMailBean> livres;
}
