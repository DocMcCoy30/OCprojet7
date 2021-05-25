package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "langue")
@Getter
@Setter
public class Langue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "langue")
    private String langue;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "langue",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Livre> livres;


}
