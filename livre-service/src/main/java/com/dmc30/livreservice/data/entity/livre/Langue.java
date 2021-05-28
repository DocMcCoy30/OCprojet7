package com.dmc30.livreservice.data.entity.livre;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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

    //bi-directionnal
//    @JsonBackReference
//    @OneToMany(mappedBy = "langue",
//            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Set<Livre> livres;


}
