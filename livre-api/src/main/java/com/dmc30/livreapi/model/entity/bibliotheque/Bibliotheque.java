package com.dmc30.livreapi.model.entity.bibliotheque;

import com.dmc30.livreapi.model.entity.commun.Adresse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bibliotheque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bibliotheque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "numero_siret")
    private String numeroSiret;

    @Column(name = "nom")
    private String nom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bibliotheque",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Ouvrage> ouvrages;
}
