package com.dmc30.empruntservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PretDto {

    private Long id;

    private Date dateEmprunt;

    private Date dateRestitution;

    private Date dateProlongation;

    private Boolean prolongation;

    private boolean restitution;

    private Long ouvrageId;

    private Long utilisateurId;
}
