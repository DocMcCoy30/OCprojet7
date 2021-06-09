package com.dmc30.empruntservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class PretDto {

    private Long id;

    private LocalDate dateEmprunt;

    private LocalDate dateRestitution;

    private LocalDate dateProlongation;

    private Boolean prolongation;

    private OuvrageDto ouvrageDto;
}
