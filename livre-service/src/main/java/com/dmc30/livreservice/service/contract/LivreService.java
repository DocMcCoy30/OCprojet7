package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.data.entity.livre.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> findAll();
    List<Livre> findLivreByTitreContaining(String motCle);
    void saveLivre(Livre livre);
    List<Livre> findLivreByAuteur(Long auteurId);
}
