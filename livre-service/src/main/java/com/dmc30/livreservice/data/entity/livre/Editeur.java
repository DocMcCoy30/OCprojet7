package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "editeur")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Editeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom_maison_edition")
    private String nomMaisonEdition;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "editeur",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonIgnore
    private List<Livre> livres;
}
