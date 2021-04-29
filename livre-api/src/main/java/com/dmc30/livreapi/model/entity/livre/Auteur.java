package com.dmc30.livreapi.model.entity.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "auteur")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "livres")
@EqualsAndHashCode(exclude = "livres")
public class Auteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private String dateNaissance;

    @Column(name = "date_deces")
    private String dateDeces;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_auteur",
            joinColumns = {@JoinColumn(name = "id_auteur")},
            inverseJoinColumns = {@JoinColumn(name = "id_livre")}
    )
    @JsonIgnore
    private List<Livre> livres;
}
