package com.dmc30.clientui.shared.utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto {

    private int id;
    private String role;
    private String description;
    private List<UsersDto> abonnes;
    private List<EmployeDto> employes;
}
