package com.dmc30.livreapi.model.entity.livre;

import com.dmc30.livreapi.model.entity.livre.Auteur;
import com.dmc30.livreapi.model.entity.livre.Editeur;
import com.dmc30.livreapi.model.entity.livre.Langue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "livre")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
            name = "many_livre_has_many_auteur",
            joinColumns = {@JoinColumn(name = "id_livre")},
            inverseJoinColumns = {@JoinColumn(name = "id_auteur")}
    )
    private List<Auteur> auteurs;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_editeur")
    private Editeur editeur;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_langue")
    private Langue langue;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_genre",
            joinColumns = { @JoinColumn(name = "id_livre") },
            inverseJoinColumns = { @JoinColumn(name = "id_genre") }
    )
    private List<Genre> genres;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
    private List<Illustration> illustrations;



}
