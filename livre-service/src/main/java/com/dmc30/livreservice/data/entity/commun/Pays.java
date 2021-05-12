package com.dmc30.livreservice.data.entity.commun.commun;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "pays")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

//    private int id;
//    private String nom = "France";
//    private String codeAlpha2 = "FR";
//    private String codeAlpha3 = "FRA";
//    private Integer code = 250;
}
