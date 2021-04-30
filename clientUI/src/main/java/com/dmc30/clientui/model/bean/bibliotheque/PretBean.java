package com.dmc30.clientui.model.bean.bibliotheque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PretBean {

    private int id;
    private OuvrageBean ouvrage;
    private Date dateEmprunt;
    private Date dateRestitution;
    private boolean prolongation;
    private Date dateProlongation;
}
