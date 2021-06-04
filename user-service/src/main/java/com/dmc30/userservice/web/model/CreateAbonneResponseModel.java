package com.dmc30.userservice.web.model;

import lombok.Data;

import java.util.Set;

@Data
public class CreateAbonneResponseModel {

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String publicId;
    private Set<Role> role;
}
