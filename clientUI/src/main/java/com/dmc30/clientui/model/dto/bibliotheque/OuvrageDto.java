package com.dmc30.clientui.model.dto.bibliotheque;

import com.dmc30.clientui.model.dto.livre.LivreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OuvrageDto {

    private int id;
    private String idInterne;
    private BibliothequeDto bibliotheque;
    private LivreDto livre;
    private boolean emprunte;
    private List<PretDto> prets;
}
