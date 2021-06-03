package com.dmc30.clientui.shared.bibliotheque;

import com.dmc30.clientui.shared.livre.LivreDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OuvrageDto {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Set<PretDto> prets;

}
