package com.dmc30.empruntservice.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "pret")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Pret {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_emprunt")
    private Date dateEmprunt;

    @Column(name = "date_restitution")
    private Date dateRestitution;

    @Column(name = "date_prolongation")
    private Date dateProlongation;

    @Column(name = "prolongation")
    private Boolean prolongation;

    @JoinColumn(name = "id_ouvrage")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Ouvrage ouvrage;

}