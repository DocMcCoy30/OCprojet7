package com.dmc30.emailservice.service.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuvrageBean {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Long bibliothequeId;
    private Long livreId;
}
