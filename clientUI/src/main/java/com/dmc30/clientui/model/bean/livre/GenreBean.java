package com.dmc30.clientui.model.bean.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GenreBean {

    private int id;
    private String genre;
    @JsonIgnore
    private List<LivreBean> livres;
}
