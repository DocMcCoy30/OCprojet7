package com.dmc30.userservice.data.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoleEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "many_utilisateur_has_many_role",
            joinColumns = {@JoinColumn(name = "id_role")},
            inverseJoinColumns = {@JoinColumn(name = "id_utilisateur")}
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<UtilisateurEntity> utilisateurEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RoleEntity that = (RoleEntity) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1197319562;
    }
}
