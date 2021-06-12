package com.dmc30.clientui.shared.bean.utilisateur;

import com.dmc30.clientui.shared.bean.commun.AdresseBean;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UtilisateurBean implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = 9136135314128148124L;

    private Long id;
    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String encryptedPassword;
    private String publicId;
    private List<RoleBean> roles;
    private String numTelephone;
    private AdresseBean adresse;
    //Abonne
    private String numAbonne;
    private Date dateCreationCompte;
    private String dateCreationCompteFormat;
//    private Set<Pret> prets;

    //Employe
    private String matricule;
    private Date dateEntree;
    private Date dateSortie;
}
