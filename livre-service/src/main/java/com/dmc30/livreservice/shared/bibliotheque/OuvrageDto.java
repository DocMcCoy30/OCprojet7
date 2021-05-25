package com.dmc30.livreservice.shared.bibliotheque;

import com.dmc30.livreservice.shared.livre.LivreDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class OuvrageDto {

    private String idInterne;
    private BibliothequeDto bibliotheque;
    private LivreDto livre;
    private boolean emprunte;
    private List<PretDto> prets;

}
