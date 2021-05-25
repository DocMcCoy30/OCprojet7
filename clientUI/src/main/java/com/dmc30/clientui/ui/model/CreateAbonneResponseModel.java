package com.dmc30.clientui.ui.model;

import com.dmc30.clientui.shared.utilisateur.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAbonneResponseModel {

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String publicId;
    private Set<RoleDto> role;
}
