package com.dmc30.empruntservice.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "ouvrage")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Ouvrage {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_interne")
    private String idInterne;

    @Column(name = "emprunte")
    private boolean emprunte;

    @Column(name = "id_bibliotheque")
    private Long bibliothequeId;

}