package com.dmc30.livreapi.service;

import com.dmc30.livreapi.exception.IntrouvableException;
import com.dmc30.livreapi.model.entity.livre.Auteur;
import com.dmc30.livreapi.repository.AuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurServiceImpl implements AuteurService {

    AuteurRepository auteurRepository;

    @Autowired
    public AuteurServiceImpl(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @Override
    public List<Auteur> findAll() {
        return auteurRepository.findAll();
    }

    @Override
    public List<Auteur> findAuteurByNomOrPrenom(String nom, String prenom) {
        List<Auteur> auteurs = auteurRepository.findAuteurByNomOrPrenom(nom, prenom);
        if (auteurs == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        }
        return auteurs;
    }

    @Override
    public Auteur findAuteurById(int id) {
        return auteurRepository.findAuteurById(id);
    }

    @Override
    public List<Auteur> findAuteurByLivres(int id) {
        return auteurRepository.findAuteurByLivres(id);
    }

    @Override
    public void save(Auteur auteur) {
        auteurRepository.save(auteur);
    }
}
