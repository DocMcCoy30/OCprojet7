package com.dmc30.userapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "abonne")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abonne {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    @NotNull(message = "Le username ne peut pas être vide")
    @Size(min = 4, message = "Le username doit contenir au moins 4 caractères ")
    private String username;

    @Column(name = "prenom")
    @NotNull(message = "Le prenom ne peut pas être vide")
    private String prenom;

    @Column(name = "nom")
    @NotNull(message = "Le nom ne peut pas être vide")
    private String nom;

    @Column(name = "email")
    @NotNull(message = "L'email ne peut pas être vide")
    @Email
    private String email;

    @Column(name = "password")
    @NotNull(message = "Le mot de passe ne peut pas être vide")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères ")
    private String password;

    @Column(name = "numero_telephone")
    private String numTelephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_abonne_has_many_role",
            joinColumns = {@JoinColumn(name = "id_abonne")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")}
    )
    private List<Role> roles;

    @Column(name = "date_creation_compte")
    private Date dateCreationCompte;

    @Column(name = "numero_abonne")
    private String numAbonne;

//    private Bibliotheque bibliothequePrefere;
//    private List<Pret> prets;
}
