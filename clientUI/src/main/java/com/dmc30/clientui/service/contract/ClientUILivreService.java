package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.livre.LivreDto;

import java.util.List;

public interface ClientUILivreService {

    List<LivreDto> getLivres();
    List<LivreDto> getLivreByTitre(String motCle);
}
