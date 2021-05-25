package com.dmc30.livreservice.shared.livre;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class LangueDto {

    private String code;
    private String langue;
    private List<LivreDto> livres;
}
