package com.dmc30.clientui.model.bean.bibliotheque;

import com.dmc30.clientui.model.bean.commun.AdresseBean;

import java.util.List;

public class BibliothequeBean {

    private int id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseBean adresse;
    private List<OuvrageBean> ouvrages;
}
