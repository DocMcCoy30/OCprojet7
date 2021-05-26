package com.dmc30.livreservice.shared.livre;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
public class IllustrationDto {

    private String url;
    private String typeIllustration;
    @JsonIgnore
    private LivreDto livre;
}
