package com.dmc30.emailservice.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "utilisateur")
public class UtilisateurEntity {


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false, unique = true)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 2028891216;
    }
}

