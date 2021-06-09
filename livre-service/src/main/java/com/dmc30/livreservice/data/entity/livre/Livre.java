package com.dmc30.livreservice.data.entity.livre;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "livre")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Livre {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "resume")
    private String resume;

    @Column(name = "date_edition")
    private String dateEdition;

    @Column(name = "numero_isbn13")
    private String numeroIsbn13;

    //uni-directionnal cf Editeur.class
    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_editeur")
    private Editeur editeur;

    //uni-directionnal cf Langue.class
    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_langue")
    private Langue langue;

    //uni-directionnal cf Auteur.class
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_auteur",
            joinColumns = {@JoinColumn(name = "id_livre")},
            inverseJoinColumns = {@JoinColumn(name = "id_auteur")}
    )
    @ToString.Exclude
    private Set<Auteur> auteurs;

    //uni-directionnal cf Genre.class
    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_genre",
            joinColumns = {@JoinColumn(name = "id_livre")},
            inverseJoinColumns = {@JoinColumn(name = "id_genre")}
    )
    @ToString.Exclude
    private Set<Genre> genres;

    //uni-directionnal
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_livre")
    @ToString.Exclude
    private Set<Illustration> illustrations;

    //uni-directionnal
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_livre")
    @ToString.Exclude
    private Set<Ouvrage> ouvrages;


    //bi-directionnal
//    @JsonManagedReference
//    @OneToMany(mappedBy = "livre")
//    private Set<Illustration> illustrations;

    //bi-directionnal
//    @JsonManagedReference
//    @OneToMany(mappedBy = "livre")
//    private Set<Ouvrage> ouvrages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Livre livre = (Livre) o;

        return id != null && id.equals(livre.id);
    }

    @Override
    public int hashCode() {
        return 1572184743;
    }
}
