package com.dmc30.livreservice.data.entity.livre;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

@Entity
@Table(name = "illustration")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Illustration {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "type_illustration")
    private String typeIllustration;

    //bi-directionnal
//    @JsonBackReference
//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "id_livre")
//    private Livre livre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Illustration that = (Illustration) o;

        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return 1119417603;
    }
}
