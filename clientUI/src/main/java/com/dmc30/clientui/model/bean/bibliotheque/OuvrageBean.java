package com.dmc30.clientui.model.bean.bibliotheque;

import com.dmc30.clientui.model.bean.livre.LivreBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OuvrageBean {

    private int id;
    private String idInterne;
    private BibliothequeBean bibliotheque;
    private LivreBean livre;
    private boolean emprunte;
    private List<PretBean> prets;
}
