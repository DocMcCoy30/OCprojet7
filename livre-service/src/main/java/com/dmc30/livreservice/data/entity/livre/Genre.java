package com.dmc30.livreservice.data.entity.livre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Genre {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genre")
    private String genre;

    //bi-directionnal
//    @JsonBackReference
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(
//            name = "many_livre_has_many_genre",
//            joinColumns = {@JoinColumn(name = "id_genre")},
//            inverseJoinColumns = {@JoinColumn(name = "id_livre")}
//    )
//    private Set<Livre> livres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Genre genre = (Genre) o;

        return id != null && id.equals(genre.id);
    }

    @Override
    public int hashCode() {
        return 1887069089;
    }
}
