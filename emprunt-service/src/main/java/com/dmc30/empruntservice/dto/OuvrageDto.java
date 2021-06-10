package com.dmc30.empruntservice.dto;

import com.dmc30.empruntservice.data.entity.Pret;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
public class OuvrageDto {

    private Long id;

    private String idInterne;

    private boolean emprunte;

    private Long bibliothequeId;
}
