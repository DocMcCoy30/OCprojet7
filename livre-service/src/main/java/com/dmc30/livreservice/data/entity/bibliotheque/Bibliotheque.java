package com.dmc30.livreservice.data.entity.bibliotheque;

import com.dmc30.livreservice.data.entity.commun.Adresse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bibliotheque")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "numero_siret")
    private String numeroSiret;

    @Column(name = "nom")
    private String nom;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_bibliotheque")
    @ToString.Exclude
    private Set<Ouvrage> ouvrages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bibliotheque that = (Bibliotheque) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1045053730;
    }
}
