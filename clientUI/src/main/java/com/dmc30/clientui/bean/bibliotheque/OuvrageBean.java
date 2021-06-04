package com.dmc30.clientui.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OuvrageBean {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Set<PretBean> prets;

}
