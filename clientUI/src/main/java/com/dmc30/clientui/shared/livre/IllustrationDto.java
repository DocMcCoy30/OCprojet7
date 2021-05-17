package com.dmc30.clientui.shared.livre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IllustrationDto {

    private String url;
    private String typeIllustration;
    private LivreDto livre;
}
