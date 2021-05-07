package com.dmc30.userapi.ui.model;

import com.dmc30.userapi.shared.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
public class CreateAbonneResponseModel {

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String publicId;
    private Set<RoleDto> role;
}
