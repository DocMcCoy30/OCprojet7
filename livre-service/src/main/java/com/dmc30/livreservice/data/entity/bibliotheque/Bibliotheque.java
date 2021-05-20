package com.dmc30.livreservice.data.entity.bibliotheque;

import com.dmc30.livreservice.data.entity.commun.Adresse;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bibliotheque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ouvrages"})
@EqualsAndHashCode(exclude = {"ouvrages"})
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "numero_siret")
    private String numeroSiret;

    @Column(name = "nom")
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    //    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bibliotheque",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JsonManagedReference
    @OneToMany(mappedBy = "bibliotheque")
    private Set<Ouvrage> ouvrages;
}
