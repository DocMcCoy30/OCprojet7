package com.dmc30.clientui.shared.bean.utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleBean {

    private String role;
    private String description;
    private List<UtilisateurBean> utilisateurs;
}
