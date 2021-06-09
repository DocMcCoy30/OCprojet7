package com.dmc30.userservice.data.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PaysEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "code_alpha2")
    private String codeAlpha2;

    @Column(name = "code_alpha3")
    private String codeAlpha3;

    @Column(name = "code")
    private Integer code;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PaysEntity that = (PaysEntity) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 154228074;
    }
}
