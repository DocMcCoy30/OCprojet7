package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private String genre;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_genre",
            joinColumns = {@JoinColumn(name = "id_genre")},
            inverseJoinColumns = {@JoinColumn(name = "id_livre")}
    )
    private List<Livre> livres;
}
