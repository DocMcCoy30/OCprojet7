package com.dmc30.userservice.web.model;

import com.dmc30.userservice.service.dto.PaysDto;
import lombok.Data;

@Data
public class Adresse {

    private String rue;
    private String codePostal;
    private String ville;
    private PaysDto pays;
}
