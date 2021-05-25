package com.dmc30.clientui.shared.bibliotheque;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class PretDto {

    private OuvrageDto ouvrage;
    private Date dateEmprunt;
    private Date dateRestitution;
    private boolean prolongation;
    private Date dateProlongation;
}
