package com.dmc30.userservice.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude={"roles"})
@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "password", nullable = false)
    private String encryptedPassword;
    @Column(name = "numero_telephone")
    private String numTelephone;
    @Column(name = "public_id")
    private String publicId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private AdresseEntity adresse;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "many_utilisateur_has_many_role", joinColumns = @JoinColumn(name = "id_utilisateur"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Set<RoleEntity> roles;

    @Column(name = "date_creation_compte")
    private Date dateCreationCompte;

    @Column(name = "numero_abonne")
    private String numAbonne;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "date_sortie")
    private Date dateSortie;
}
