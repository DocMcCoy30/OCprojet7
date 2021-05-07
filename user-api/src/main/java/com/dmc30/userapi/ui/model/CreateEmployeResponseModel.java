package com.dmc30.userapi.ui.model;

import lombok.Data;

@Data
public class CreateEmployeResponseModel {

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String publicId;
}
