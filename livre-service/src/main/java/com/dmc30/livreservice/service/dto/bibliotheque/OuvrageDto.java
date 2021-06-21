package com.dmc30.livreservice.service.dto.bibliotheque;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OuvrageDto {

    private Long id;
    private String idInterne;
    private boolean emprunte;
    private Long bibliothequeId;
    private Long livreId;
    @JsonIgnore
    private List<PretDto> prets;

}
