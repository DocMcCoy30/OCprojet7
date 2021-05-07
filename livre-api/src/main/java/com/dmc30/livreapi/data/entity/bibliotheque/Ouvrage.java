package com.dmc30.livreapi.data.entity.bibliotheque;

import com.dmc30.livreapi.data.entity.livre.Livre;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ouvrage")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "livre")
@EqualsAndHashCode(exclude = "livre")
public class Ouvrage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_interne")
    private String idInterne;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_bibliotheque")
    private Bibliotheque bibliotheque;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_livre")
    private Livre livre;

    @Column(name = "emprunte")
    private boolean emprunte;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ouvrage")
//    private List<Pret> prets;
}
