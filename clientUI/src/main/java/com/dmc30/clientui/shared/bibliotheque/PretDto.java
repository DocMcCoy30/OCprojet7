package com.dmc30.clientui.shared.bibliotheque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PretDto {

    private OuvrageDto ouvrage;
    private Date dateEmprunt;
    private Date dateRestitution;
    private boolean prolongation;
    private Date dateProlongation;
}
