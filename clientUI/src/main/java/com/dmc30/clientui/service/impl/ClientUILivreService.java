package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.model.dto.livre.LivreDto;

import java.util.List;

public interface ClientUILivreService {

    List<LivreDto> getLivres();
    List<LivreDto> getLivreByTitre(String motCle);
}
