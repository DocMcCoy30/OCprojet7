package com.dmc30.clientui.model.bean.utilisateur;

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

    private int id;
    private String role;
    private String description;
    private List<AbonneBean> abonnes;
    private List<EmployeBean> employes;
}
