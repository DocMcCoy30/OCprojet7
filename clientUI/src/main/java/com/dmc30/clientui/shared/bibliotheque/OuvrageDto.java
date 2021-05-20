package com.dmc30.clientui.shared.bibliotheque;

import com.dmc30.clientui.shared.livre.LivreDto;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@ToString(exclude = {"bibliotheque"})
//@EqualsAndHashCode(exclude = {"bibliotheque"})
public class OuvrageDto {

    private String idInterne;
    private BibliothequeDto bibliotheque;
    private LivreDto livre;
    private boolean emprunte;
    private List<PretDto> prets;

}
