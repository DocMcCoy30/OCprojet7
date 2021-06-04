package com.dmc30.clientui.service.dto.bibliotheque;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OuvrageDto {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Set<PretDto> prets;

}
