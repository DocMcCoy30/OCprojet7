package com.dmc30.livreapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "livre")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "titre")
    private String titre;
    @Column(name = "resume")
    private String resume;
    @Column(name = "date_edition")
    private String dateEdition;
    @Column(name = "numero_isbn13")
    private String numeroIsbn13;
}
