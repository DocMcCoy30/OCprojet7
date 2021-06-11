package com.dmc30.clientui.shared.bean.bibliotheque;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class PretBean {

    private Long id;
    private Date dateEmprunt;
    private Date dateRestitution;
    private Date dateProlongation;
    private boolean prolongation;
    private boolean restitution;
    private Long ouvrageId;
    private Long utilisateurId;
}
