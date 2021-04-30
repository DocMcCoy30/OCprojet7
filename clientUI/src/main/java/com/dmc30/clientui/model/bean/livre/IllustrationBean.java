package com.dmc30.clientui.model.bean.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IllustrationBean {

    private int id;
    private String url;
    private String typeIllustration;
    private LivreBean livre;
}
