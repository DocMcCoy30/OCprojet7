package com.dmc30.clientui.model.bean.bibliotheque;

import com.dmc30.clientui.model.bean.commun.AdresseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BibliothequeBean {

    private int id;
    private String code;
    private String numSiret;
    private String nom;
    private AdresseBean adresse;
    private List<OuvrageBean> ouvrages;
}
