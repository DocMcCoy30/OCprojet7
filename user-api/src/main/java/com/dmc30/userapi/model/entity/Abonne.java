package com.dmc30.userapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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
    private String username;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
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
