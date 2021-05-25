package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editeur")
@Getter
@Setter
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_maison_edition")
    private String nomMaisonEdition;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "editeur",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Livre> livres;
}
