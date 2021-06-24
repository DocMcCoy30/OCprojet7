package com.dmc30.clientui.shared.bean.utilisateur;

import com.dmc30.clientui.shared.bean.commun.AdresseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAbonneBean {

    @NotNull(message="Username cannot be null")
    @Size(min=2, message= "Username doit contenir au moins 2 caractères")
    private String username;
    @NotNull(message="Prenom cannot be null")
    @Size(min=2, message= "Le prenom  doit contenir au moins 2 caractères")
    private String prenom;
    @NotNull(message="Last name cannot be null")
    @Size(min=2, message= "Le nom doit contenir au moins 2 caractères")
    private String nom;
    @NotNull(message="Email cannot be null")
    @Email
    @Pattern(regexp="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "L'email renseigné n'est pas conforme")
    private String email;
    @NotNull(message="Password cannot be null")
    @Size(min=6, max=16, message="Le mot de passe doit contenir entre 6 et 16 caractères")
    private String password;
    @NotNull(message="Phone Number cannot be null")
    @Size(min=10, max=10, message="Le numéro de téléphone doit contenir 10 chiffres")
    private String numTelephone;
    private AdresseBean adresse;
    private int paysId;
}
