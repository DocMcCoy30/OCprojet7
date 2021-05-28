package com.dmc30.clientui.shared.bibliotheque;

import com.dmc30.clientui.shared.livre.LivreDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OuvrageDto {

    private String idInterne;
    private boolean emprunte;
    private List<PretDto> prets;

}
