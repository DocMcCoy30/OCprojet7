package com.dmc30.livreapi.service.contract;

import com.dmc30.livreapi.data.entity.livre.Livre;

import java.util.List;

public interface LivreService {

    List<Livre> findAll();
    List<Livre> findLivreByTitreContaining(String motCle);
    void saveLivre(Livre livre);
}
