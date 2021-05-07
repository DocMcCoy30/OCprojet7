package com.dmc30.userapi.data.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employe")
public class EmployeEntity implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = -6277111464913867750L;

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
    @Column(nullable = false, unique = true)
    private String publicId;

    @Column(name = "numero_telephone")
    private String numTelephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private AdresseEntity adresseEntity;

@ManyToMany(fetch = FetchType.LAZY,
        cascade = {CascadeType.DETACH, CascadeType.MERGE , CascadeType.REFRESH})
@JoinTable(
        name = "many_employe_has_many_role",
        joinColumns = {@JoinColumn(name = "id_employe")},
        inverseJoinColumns = {@JoinColumn(name = "id_role")})
private Set<RoleEntity> roles;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "date_sortie")
    private Date dateSortie;
}
