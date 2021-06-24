package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.shared.bean.livre.GenreBean;
import com.dmc30.clientui.shared.bean.livre.LivreResponseModelBean;
import com.dmc30.clientui.web.exception.TechnicalException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LivreService {

    List<LivreResponseModelBean> getLivres() throws TechnicalException;
    List<LivreResponseModelBean> get12LastLivres() throws TechnicalException;
    ResponseEntity<?> getLivreById(Long id);
    List<LivreResponseModelBean> getLivreByTitre(String motCle) throws TechnicalException;
    List<LivreResponseModelBean> getLivreByAuteur(Long auteurId) throws TechnicalException;
    String formatListeAuteurs (List<AuteurBean> auteurs);
    String formatListeGenres(List<GenreBean> genres);

}
