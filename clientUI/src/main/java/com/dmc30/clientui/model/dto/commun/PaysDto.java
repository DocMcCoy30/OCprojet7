package com.dmc30.clientui.model.dto.commun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaysDto {

    private int id;
    private String nom;
    private String codeAlpha2;
    private String codeAlpha3;
    private Integer code;
}
