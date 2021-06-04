package com.dmc30.clientui.bean.bibliotheque;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class PretBean {

    private OuvrageBean ouvrage;
    private Date dateEmprunt;
    private Date dateRestitution;
    private boolean prolongation;
    private Date dateProlongation;
}
