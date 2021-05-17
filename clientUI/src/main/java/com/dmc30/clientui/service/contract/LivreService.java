package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.livre.LivreDto;

import java.util.List;

public interface LivreService {

    List<LivreDto> getLivres();
    List<LivreDto> get12LastLivres();
    List<LivreDto> getLivreByTitre(String motCle);
    List<LivreDto> getLivreByAuteur(String motCle);
}
