package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.data.entity.livre.Livre;
import com.dmc30.livreservice.shared.livre.LivreDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LivreService {

    List<Livre> findAll();
    List<Livre> findLivreByTitreContaining(String motCle);
    void saveLivre(Livre livre);
    List<Livre> findLivreByAuteur(Long auteurId);
    List<Livre> findLast12();
    LivreDto findLivreById(Long livreId);
}
