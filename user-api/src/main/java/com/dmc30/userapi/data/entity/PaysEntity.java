package com.dmc30.userapi.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaysEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "code_alpha2")
    private String codeAlpha2;

    @Column(name = "code_alpha3")
    private String codeAlpha3;

    @Column(name = "code")
    private Integer code;
}
