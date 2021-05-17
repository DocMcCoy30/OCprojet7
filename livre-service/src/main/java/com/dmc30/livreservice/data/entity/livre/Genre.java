package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "livres")
@EqualsAndHashCode(exclude = "livres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "genre")
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_livre_has_many_genre",
            joinColumns = {@JoinColumn(name = "id_genre")},
            inverseJoinColumns = {@JoinColumn(name = "id_livre")}
    )
    @JsonIgnore
    private List<Livre> livres;
}
