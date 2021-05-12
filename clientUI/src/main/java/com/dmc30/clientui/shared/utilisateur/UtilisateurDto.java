package com.dmc30.clientui.shared.utilisateur;

import com.dmc30.clientui.shared.commun.AdresseDto;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UtilisateurDto implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = 9136135314128148124L;

    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String encryptedPassword;
    private String publicId;
    private Set<RoleDto> roles;
    private String numTelephone;
    private AdresseDto adresse;
    //Abonne
    private Date dateCreationCompte;
//    private List<Pret> prets;

    //Employe
    private String matricule;
    private Date dateEntree;
    private Date dateSortie;
}
