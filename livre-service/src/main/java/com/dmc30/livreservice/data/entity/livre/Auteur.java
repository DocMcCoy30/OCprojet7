package com.dmc30.livreservice.data.entity.livre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "auteur")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Auteur {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @Column(name = "date_deces")
    private String dateDeces;

//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(
//            name = "many_livre_has_many_auteur",
//            joinColumns = {@JoinColumn(name = "id_auteur")},
//            inverseJoinColumns = {@JoinColumn(name = "id_livre")}
//    )
//    private Set<Livre> livres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Auteur auteur = (Auteur) o;

        return id != null && id.equals(auteur.id);
    }

    @Override
    public int hashCode() {
        return 1193349664;
    }
}
