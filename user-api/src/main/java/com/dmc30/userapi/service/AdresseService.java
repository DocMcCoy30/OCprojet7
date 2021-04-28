package com.dmc30.userapi.service;

import com.dmc30.userapi.model.entity.Adresse;

public interface AdresseService {

    Adresse findAdresseById(int adresseId);

    void createAdresse(Adresse adresse);

    Integer getMaxId();

}
