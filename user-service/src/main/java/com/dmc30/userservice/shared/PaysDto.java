package com.dmc30.userservice.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaysDto {

    private String nom;
    private String codeAlpha2;
    private String codeAlpha3;
    private Integer code;
}
