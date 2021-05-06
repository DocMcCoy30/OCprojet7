package com.dmc30.userapi.service.contract;

import com.dmc30.userapi.exception.TechnicalException;
import com.dmc30.userapi.model.entity.Adresse;

public interface AdresseService {

    Adresse findAdresseById(int adresseId) throws TechnicalException;

    void createAdresse(Adresse adresse);

    Integer findMaxId();

}
