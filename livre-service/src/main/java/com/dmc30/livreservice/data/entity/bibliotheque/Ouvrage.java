package com.dmc30.livreservice.data.entity.bibliotheque;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "ouvrage")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "id_interne")
    private String idInterne;

    @Column(name = "emprunte")
    private boolean emprunte;

    @Column(name = "id_bibliotheque")
    private Long bibliothequeId;

    @Column(name = "id_livre")
    private Long livreId;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ouvrage ouvrage = (Ouvrage) o;

        return id != null && id.equals(ouvrage.id);
    }

    @Override
    public int hashCode() {
        return 1164956415;
    }
}
