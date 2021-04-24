package com.dmc30.livreapi.model.entity.commun;

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
    private String nom = "France";

    @Column(name = "code_alpha2")
    private String codeAlpha2 = "FR";

    @Column(name = "code_alpha3")
    private String codeAlpha3 = "FRA";

    @Column(name = "code")
    private Integer code = 250;
}
