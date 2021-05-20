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

    @Override
    public List<Bibliotheque> findAll() {
        return bibliothequeRepository.findAll();
    }

    @Override
    public Bibliotheque findById(Long bibliothequeid) {
        Bibliotheque bibliotheque = new Bibliotheque();
        Optional<Bibliotheque> result = bibliothequeRepository.findById(bibliothequeid);
        if (result.isPresent()) {
            bibliotheque = result.get();
        }
        return bibliotheque;
    }
}
