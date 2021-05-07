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
@Table(name = "abonne")
public class AbonneEntity implements Serializable {

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private static final long serialVersionUID = -6668241825408314013L;

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

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "many_abonne_has_many_role",
            joinColumns = {@JoinColumn(name = "id_abonne")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")}
    )
    private Set<RoleEntity> roles;

    @Column(name = "date_creation_compte")
    private Date dateCreationCompte;

    @Column(name = "numero_abonne")
    private String numAbonne;

//    private Bibliotheque bibliothequePrefere;
//    private List<Pret> prets;
}
