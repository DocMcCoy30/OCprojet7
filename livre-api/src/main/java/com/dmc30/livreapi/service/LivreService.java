package com.dmc30.livreapi.service;

import com.dmc30.livreapi.model.entity.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> findAll();
    List<Livre> findLivreByTitreContaining(String motCle);
    void saveLivre(Livre livre);
}
