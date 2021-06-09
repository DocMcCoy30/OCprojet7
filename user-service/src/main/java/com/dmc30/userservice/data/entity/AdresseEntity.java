package com.dmc30.userservice.data.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "adresse")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class AdresseEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rue")
    private String rue;

    @Column(name = "code_postal")
    private String codePostal;

    @Column(name = "ville")
    private String ville;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pays")
    private PaysEntity paysEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AdresseEntity that = (AdresseEntity) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 993389274;
    }
}
