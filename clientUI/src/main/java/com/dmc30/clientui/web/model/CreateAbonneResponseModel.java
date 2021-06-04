package com.dmc30.clientui.web.model;

import com.dmc30.clientui.bean.utilisateur.RoleBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAbonneResponseModel {


    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String publicId;
    private List<RoleBean> role;
}
