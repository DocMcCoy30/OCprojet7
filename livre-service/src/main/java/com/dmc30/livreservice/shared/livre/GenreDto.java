package com.dmc30.livreservice.shared.livre;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Setter
public class GenreDto {

    private String genre;
    @JsonIgnore
    private List<LivreDto> livres;
}
