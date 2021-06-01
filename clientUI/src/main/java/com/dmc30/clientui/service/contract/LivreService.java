package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.livre.AuteurDto;
import com.dmc30.clientui.ui.model.LivreResponseModel;

import java.util.List;

public interface LivreService {

    List<LivreResponseModel> getLivres();
    List<LivreResponseModel> get12LastLivres();
    LivreResponseModel getLivreById(Long id);
    List<LivreResponseModel> getLivreByTitre(String motCle);
    List<LivreResponseModel> getLivreByAuteur(Long auteurId);
    String formatListeAuteurs (List<AuteurDto> auteurs);

}
