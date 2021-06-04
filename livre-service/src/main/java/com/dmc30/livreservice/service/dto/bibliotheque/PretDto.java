package com.dmc30.livreservice.service.dto.bibliotheque;

import lombok.Getter;
import lombok.Setter;

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
