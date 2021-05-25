package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.entity.livre.Livre;
import com.dmc30.livreservice.data.repository.LivreRepository;
import com.dmc30.livreservice.exception.IntrouvableException;
import com.dmc30.livreservice.service.contract.LivreService;
import com.dmc30.livreservice.shared.livre.LivreDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    Logger logger = LoggerFactory.getLogger(LivreServiceImpl.class);

    LivreRepository livreRepository;

    @Autowired
    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<Livre> findAll() {
        List<Livre> livres = livreRepository.findAll();
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return livres;
    }

    @Override
    public List<Livre> findLivreByTitreContaining(String motCle) {
        List<Livre> livres = livreRepository.findLivreByTitreContaining(motCle);
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return livres;
    }

    @Override
    public void saveLivre(Livre livre) {
        livreRepository.save(livre);
    }

    @Override
    public List<Livre> findLivreByAuteur(Long auteurId) {
        List<Livre> livres = livreRepository.findLivreByAuteur(auteurId);
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else return livres;
    }

    @Override
    public List<Livre> findLast12() {
        Page<Livre> livresPage = livreRepository.findLast12(PageRequest.of(0, 12, Sort.by("id").descending()));
        List<Livre> livres = livresPage.getContent();
        return livres;
    }

    @Override
    public LivreDto findLivreById(Long livreId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Livre livre = livreRepository.findLivreById(livreId);
        logger.info("Livre entity with id " + livreId + " = " + livre);
        LivreDto livreDto = modelMapper.map(livre, LivreDto.class);
        return livreDto;
    }
}
