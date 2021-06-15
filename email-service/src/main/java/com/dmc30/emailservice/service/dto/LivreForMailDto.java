package com.dmc30.emailservice.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LivreForMailDto {

    private String titre;
    private Date dateRestitution;
}
