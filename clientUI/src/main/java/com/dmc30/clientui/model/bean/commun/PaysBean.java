package com.dmc30.clientui.model.bean.commun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaysBean {

    private int id;
    private String nom;
    private String codeAlpha2;
    private String codeAlpha3;
    private Integer code;
}
