package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.exception.IntrouvableException;
import com.dmc30.livreservice.data.entity.livre.Auteur;
import com.dmc30.livreservice.data.repository.AuteurRepository;
import com.dmc30.livreservice.service.contract.AuteurService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuteurServiceImpl implements AuteurService {

    AuteurRepository auteurRepository;

    @Autowired
    public AuteurServiceImpl(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    @Override
    public List<Auteur> findAll() {
        List<Auteur> auteurs = auteurRepository.findAll();
        if (auteurs.isEmpty()) {
            throw new IntrouvableException("Aucun résultat de recherche");
        }
        return auteurs;
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
        Optional<Auteur> result = auteurRepository.findById(id);
        Auteur auteur = null;
        if (result.isPresent()) {
            auteur = result.get();
        } else throw new IntrouvableException("Auteur non trouvé");
        return auteur;
    }

    @Override
    public List<Auteur> findAuteurByLivres(int id) {
        Hibernate.initialize(auteurRepository.findAuteurByLivres(id));
        return auteurRepository.findAuteurByLivres(id);
    }

    @Override
    public void save(Auteur auteur) {
        auteurRepository.save(auteur);
    }
}
