package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;
import com.dmc30.livreservice.data.repository.BibliothequeRepository;
import com.dmc30.livreservice.service.contract.BibliothequeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {

    BibliothequeRepository bibliothequeRepository;

    @Autowired
    public BibliothequeServiceImpl(BibliothequeRepository bibliothequeRepository) {
        this.bibliothequeRepository = bibliothequeRepository;
    }

    /**
     * Récupère la liste de toutes les bibliothèques de la BD
     * @return la liste des bibliothèques
     */
    @Override
    public List<Bibliotheque> findAll() {
        return bibliothequeRepository.findAll();
    }

    /**
     * Cherche un objet bibliothèque dans la BD par son identifiant. Si l'identifiant n'est pas précisé, renvoie la 1ère bibliothèque enregistrée.
     * @param bibliothequeid L'identifiant de la bibliothèque rcherchée
     * @return un objet bibliothèque
     */
    @Override
    public Bibliotheque findById(Long bibliothequeid) {
        Bibliotheque bibliotheque = new Bibliotheque();
        if (bibliothequeid==null) {
            bibliothequeid = 1L;
        }
        Optional<Bibliotheque> result = bibliothequeRepository.findById(bibliothequeid);
        if (result.isPresent()) {
            bibliotheque = result.get();
        }
        return bibliotheque;
    }
}
