package com.dmc30.livreservice.data.entity.livre;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_editeur")
    private Editeur editeur;

    @JsonManagedReference
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_langue")
    private Langue langue;

//    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_auteur",
            joinColumns = {@JoinColumn(name = "id_livre")},
            inverseJoinColumns = {@JoinColumn(name = "id_auteur")}
    )
    private List<Auteur> auteurs;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_genre",
            joinColumns = {@JoinColumn(name = "id_livre")},
            inverseJoinColumns = {@JoinColumn(name = "id_genre")}
    )
    private List<Genre> genres;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
    private List<Illustration> illustrations;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
    private List<Ouvrage> ouvrages;


}
