package com.dmc30.livreapi.service;

import com.dmc30.livreapi.exception.IntrouvableException;
import com.dmc30.livreapi.model.Livre;
import com.dmc30.livreapi.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    LivreRepository livreRepository;

    @Autowired
    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    @Override
    public List<Livre> findLivreByTitreContaining(String motCle) {
        List<Livre> livres = livreRepository.findLivreByTitreContaining(motCle);
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return livres;
    }
}
