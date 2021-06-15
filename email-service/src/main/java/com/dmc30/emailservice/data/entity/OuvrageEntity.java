package com.dmc30.emailservice.data.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "ouvrage")
@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class OuvrageEntity {

    @Column(name = "id", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_livre")
    private Long livreId;
}
