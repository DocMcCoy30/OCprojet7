package com.dmc30.livreapi.model.entity.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "illustration")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "livre")
@EqualsAndHashCode(exclude = "livre")
public class Illustration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url")
    private String url;

    @Column(name = "type_illustration")
    private String typeIllustration;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_livre")
    private Livre livre;
}
