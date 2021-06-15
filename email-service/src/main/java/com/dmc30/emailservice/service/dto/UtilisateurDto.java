package com.dmc30.emailservice.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class UtilisateurDto implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = 9136135314128148124L;

    private Long id;
    private String username;
    private String prenom;
    private String nom;
    private String email;

}
