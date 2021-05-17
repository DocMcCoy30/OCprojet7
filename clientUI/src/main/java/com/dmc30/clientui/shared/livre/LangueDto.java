package com.dmc30.clientui.shared.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LangueDto {

    private String code;
    private String langue;
    private List<LivreDto> livres;
}
