package com.dmc30.livreapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livre")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "resume")
    private String resume;
    @Column(name = "date_edition")
    private String dateEdition;
    @Column(name = "numero_isbn13")
    private String numeroIsbn13;
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "auteurs_livres",
            joinColumns = { @JoinColumn(name = "id_livre") },
            inverseJoinColumns = { @JoinColumn(name = "id_auteur") }
    )
    private List<Auteur> auteurs;
}
