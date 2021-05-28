package com.dmc30.livreservice.data.entity.bibliotheque;

import com.dmc30.livreservice.data.entity.livre.Livre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ouvrage")
@Getter
@Setter
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_interne")
    private String idInterne;

    @Column(name = "emprunte")
    private boolean emprunte;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ouvrage")
//    private Set<Pret> prets;

    //bi-directionnal
//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "id_bibliotheque")
//    private Bibliotheque bibliotheque;

    //bi-directionnal
//    @JsonBackReference
//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "id_livre")
//    private Livre livre;


}
