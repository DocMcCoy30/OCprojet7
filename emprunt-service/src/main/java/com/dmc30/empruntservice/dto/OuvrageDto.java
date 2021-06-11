package com.dmc30.empruntservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OuvrageDto {

    private Long id;

    private String idInterne;

    private boolean emprunte;

    private Long bibliothequeId;
}
