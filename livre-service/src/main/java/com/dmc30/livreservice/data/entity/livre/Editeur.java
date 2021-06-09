package com.dmc30.livreservice.data.entity.livre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "editeur")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Editeur {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom_maison_edition")
    private String nomMaisonEdition;

    //bi-directionnal
//    @JsonBackReference
//    @OneToMany(mappedBy = "editeur",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Set<Livre> livres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Editeur editeur = (Editeur) o;

        return id != null && id.equals(editeur.id);
    }

    @Override
    public int hashCode() {
        return 241022994;
    }
}
