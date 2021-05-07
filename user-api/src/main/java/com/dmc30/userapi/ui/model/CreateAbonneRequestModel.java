package com.dmc30.userapi.ui.model;

import com.dmc30.userapi.shared.AdresseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAbonneRequestModel {

    @NotNull(message="Username cannot be null")
    @Size(min=2, message= "Username must not be less than two characters")
    private String username;
    @NotNull(message="Prenom cannot be null")
    @Size(min=2, message= "Prenom must not be less than two characters")
    private String prenom;
    @NotNull(message="Last name cannot be null")
    @Size(min=2, message= "Last name must not be less than two characters")
    private String nom;
    @NotNull(message="Email cannot be null")
    @Email
    private String email;
    @NotNull(message="Password cannot be null")
    @Size(min=8, max=16, message="Password must be equal or grater than 8 characters and less than 16 characters")
    private String password;
    private String numTelephone;
    private Adresse adresse;
    private int paysId;
}
