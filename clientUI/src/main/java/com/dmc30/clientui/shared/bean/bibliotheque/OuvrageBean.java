package com.dmc30.clientui.shared.bean.bibliotheque;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OuvrageBean {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Long bibliothequeId;
    private Long livreId;
    private Set<PretBean> prets;

}
