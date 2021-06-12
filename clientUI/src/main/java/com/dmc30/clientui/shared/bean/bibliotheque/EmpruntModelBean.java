package com.dmc30.clientui.shared.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpruntModelBean {

    private Long empruntId;
    private Date dateEmprunt;
    private Date dateRetour;
    private boolean prolongation;
    private boolean restitution;
    private String identifiantOuvrage;
    private String titreDuLivre;
    private Long abonneId;
    private String abonne;
}
