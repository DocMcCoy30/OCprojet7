package com.dmc30.livreservice.shared.bibliotheque;

import com.dmc30.livreservice.shared.livre.LivreDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class OuvrageDto {

    private String idInterne;
    @JsonIgnore
    private BibliothequeDto bibliotheque;
    @JsonIgnore
    private LivreDto livre;
    private boolean emprunte;
    @JsonIgnore
    private List<PretDto> prets;

}
