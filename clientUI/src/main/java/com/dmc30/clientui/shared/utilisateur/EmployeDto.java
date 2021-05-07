package com.dmc30.clientui.shared.utilisateur;

import com.dmc30.clientui.shared.commun.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeDto {

    private int id;
    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String numTelephone;
    private AdresseDto adresse;
    private List<RoleDto> roles;
    private Date dateCreationCompte;
    private String matricule;
    private Date dateEntree;
    private Date dateSortie;
}
