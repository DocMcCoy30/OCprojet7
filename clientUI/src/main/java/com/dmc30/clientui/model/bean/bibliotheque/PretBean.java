package com.dmc30.clientui.model.bean.bibliotheque;

import java.util.Date;

public class PretBean {

    private int id;
    private OuvrageBean ouvrage;
    private Date dateEmprunt;
    private Date dateRestitution;
    private boolean prolongation;
    private Date dateProlongation;
}
