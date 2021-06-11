package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.shared.bean.livre.GenreBean;
import com.dmc30.clientui.shared.bean.livre.LivreResponseModelBean;

import java.util.List;

public interface LivreService {

    List<LivreResponseModelBean> getLivres();
    List<LivreResponseModelBean> get12LastLivres();
    LivreResponseModelBean getLivreById(Long id);
    List<LivreResponseModelBean> getLivreByTitre(String motCle);
    List<LivreResponseModelBean> getLivreByAuteur(Long auteurId);
    String formatListeAuteurs (List<AuteurBean> auteurs);
    String formatListeGenres(List<GenreBean> genres);

}
