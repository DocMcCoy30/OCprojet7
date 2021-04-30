package com.dmc30.clientui.model.bean.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LangueBean {

    private int id;
    private String code;
    private String langue;
    private List<LivreBean> livres;
}
