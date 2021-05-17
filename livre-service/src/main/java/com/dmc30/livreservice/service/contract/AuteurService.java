package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.data.entity.livre.Auteur;

import java.util.List;

public interface AuteurService {

    List<Auteur> findAll();
    List<Auteur> findAuteurByNomOrPrenom(String nom, String prenom);
    Auteur findAuteurById(Long id);
    List<Auteur> findAuteurByLivres(Long id);
    void save(Auteur auteur);
    List<Auteur> findAuteurByNomContaining(String motCle);
}
