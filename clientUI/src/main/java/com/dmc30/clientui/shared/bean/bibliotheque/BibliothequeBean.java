package com.dmc30.clientui.shared.bean.bibliotheque;

import com.dmc30.clientui.shared.bean.commun.AdresseBean;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class BibliothequeBean {

    private Long id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseBean adresse;
    private List<OuvrageBean> ouvrages;



}
