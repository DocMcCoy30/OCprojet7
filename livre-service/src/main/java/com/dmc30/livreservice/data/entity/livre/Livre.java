package com.dmc30.livreservice.data.entity.livre;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "livre")
@Getter
@Setter
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    private Set<Genre> genres;

    //uni-directionnal
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_livre")
    private Set<Illustration> illustrations;

    //uni-directionnal
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_livre")
    private Set<Ouvrage> ouvrages;


    //bi-directionnal
//    @JsonManagedReference
//    @OneToMany(mappedBy = "livre")
//    private Set<Illustration> illustrations;

    //bi-directionnal
//    @JsonManagedReference
//    @OneToMany(mappedBy = "livre")
//    private Set<Ouvrage> ouvrages;
}
