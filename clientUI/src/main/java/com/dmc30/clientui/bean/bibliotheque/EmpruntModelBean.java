package com.dmc30.clientui.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmpruntModelBean {

    private Long empruntId;
    private Date dateEmprunt;
    private Date dateRetourPrevu;
    private boolean prolongation;
    private String identifiantOuvrage;
    private String titreDuLivre;
    private Long abonneId;
    private String abonne;
}
