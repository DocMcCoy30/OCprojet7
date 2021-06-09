package com.dmc30.livreservice.data.entity.commun;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "code_alpha2")
    private String codeAlpha2;

    @Column(name = "code_alpha3")
    private String codeAlpha3;

    @Column(name = "code")
    private Integer code;

//    private int id;
//    private String nom = "France";
//    private String codeAlpha2 = "FR";
//    private String codeAlpha3 = "FRA";
//    private Integer code = 250;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pays pays = (Pays) o;

        return id != null && id.equals(pays.id);
    }

    @Override
    public int hashCode() {
        return 1728348516;
    }
}
