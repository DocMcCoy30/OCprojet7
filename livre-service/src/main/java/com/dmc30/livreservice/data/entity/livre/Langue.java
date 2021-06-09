package com.dmc30.livreservice.data.entity.livre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "langue")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Langue {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "langue")
    private String langue;

    //bi-directionnal
//    @JsonBackReference
//    @OneToMany(mappedBy = "langue",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Set<Livre> livres;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Langue langue = (Langue) o;

        return id != null && id.equals(langue.id);
    }

    @Override
    public int hashCode() {
        return 1713841879;
    }
}
