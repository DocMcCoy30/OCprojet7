package com.dmc30.userapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "code_alpha2")
    private String codeAlpha2;

    @Column(name = "code_alpha3")
    private String codeAlpha3;

    @Column(name = "code")
    private Integer code;
}
