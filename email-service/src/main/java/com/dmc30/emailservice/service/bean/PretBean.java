package com.dmc30.emailservice.service.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PretBean {

    private Long id;

    private Date dateEmprunt;

    private Date dateRestitution;

    private Date dateProlongation;

    private Boolean prolongation;

    private boolean restitution;

    private Long ouvrageId;

    private Long utilisateurId;
}
