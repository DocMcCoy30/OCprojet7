package com.dmc30.userapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


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
    private String username;
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String numTelephone;
    private Adresse adresse;
    private Role role;
    private Date dateCreationCompte;
    private String numAbonne;
//    private Bibliotheque bibliothequePrefere;
//    private List<Pret> prets;
}
