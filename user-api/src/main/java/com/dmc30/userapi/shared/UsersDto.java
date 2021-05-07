package com.dmc30.userapi.shared;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = 9136135314128148124L;

    private String username;
    private String prenom;
    private String nom;
    private String email;
//    private String password;
    private String encryptedPassword;
    private String publicId;
    private Set<RoleDto> roles;
    private String numTelephone;
    private AdresseDto adresse;
    //    //Abonne
    private Date dateCreationCompte;
//    private Bibliotheque bibliothequePrefere;
//    private List<Pret> prets;
    //
//    //Employe
    private String matricule;
    private Date dateEntree;
    private Date dateSortie;
//
//    //Abonne Constructor
//    public UtilisateurDto(String username, String prenom, String nom, String email, String password, String encryptedPassword, String userId, Set<RoleDto> roleDtos, Date dateCreationCompte, String numTelephone, Bibliotheque bibliothequePrefere, List<Pret> prets) {
//        this.username = username;
//        this.prenom = prenom;
//        this.nom = nom;
//        this.email = email;
//        this.password = password;
//        this.encryptedPassword = encryptedPassword;
//        this.userId = userId;
//        this.roleDtos = roleDtos;
//        this.dateCreationCompte = dateCreationCompte;
//        this.numTelephone = numTelephone;
//        this.bibliothequePrefere = bibliothequePrefere;
//        this.prets = prets;
//    }
//
//    //Employe constructor
//    public UtilisateurDto(String username, String prenom, String nom, String email, String password, String encryptedPassword, String userId, Set<RoleDto> roleDtos, Date dateCreationCompte, String numTelephone, String matricule, Date dateEntree, Date dateSortie) {
//        this.username = username;
//        this.prenom = prenom;
//        this.nom = nom;
//        this.email = email;
//        this.password = password;
//        this.encryptedPassword = encryptedPassword;
//        this.userId = userId;
//        this.roleDtos = roleDtos;
//        this.dateCreationCompte = dateCreationCompte;
//        this.numTelephone = numTelephone;
//        this.matricule = matricule;
//        this.dateEntree = dateEntree;
//        this.dateSortie = dateSortie;
//    }
}
