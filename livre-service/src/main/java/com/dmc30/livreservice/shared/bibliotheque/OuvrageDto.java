package com.dmc30.livreservice.shared.bibliotheque;

import com.dmc30.livreservice.shared.livre.LivreDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OuvrageDto {

    private String idInterne;
    private boolean emprunte;
    @JsonIgnore
    private List<PretDto> prets;

}
