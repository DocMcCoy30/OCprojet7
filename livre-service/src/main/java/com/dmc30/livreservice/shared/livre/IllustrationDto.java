package com.dmc30.livreservice.shared.livre;

import lombok.*;

@Getter
@Setter
public class IllustrationDto {

    private String url;
    private String typeIllustration;
    private LivreDto livre;
}
