package com.dmc30.livreservice.shared.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
public class LangueDto {

    private String code;
    private String langue;
    @JsonIgnore
    private List<LivreDto> livres;
}
