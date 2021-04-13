package com.dmc30.livreapi.service;

import com.dmc30.livreapi.model.entity.Auteur;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuteurService {

    List<Auteur> findAll();
    List<Auteur> findAuteurByNomOrPrenom(String nom, String prenom);
    Auteur findAuteurById(int id);
    List<Auteur> findAuteurByLivres(int id);
    void save(Auteur auteur);
}
