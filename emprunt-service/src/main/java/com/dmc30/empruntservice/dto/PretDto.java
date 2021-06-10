package com.dmc30.empruntservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
public class PretDto {

    private Long id;

    private Date dateEmprunt;

    private Date dateRestitution;

    private Date dateProlongation;

    private Boolean prolongation;

    private Long ouvrageId;

    private Long utilisateurId;
}
