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

import java.util.ArrayList;
import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    Logger logger = LoggerFactory.getLogger(LivreServiceImpl.class);

    LivreRepository livreRepository;

    @Autowired
    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    /**
     * Cherche tous les livres enregistrés dans la base de données
     * @return la liste de tous les livres
     */
    @Override
    public List<LivreDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreDto> livreDtos = new ArrayList<>();
        List<Livre> livres = livreRepository.findAll();
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else {
            for (Livre livre : livres) {
                livreDtos.add(modelMapper.map(livre, LivreDto.class));
            }
        }
        return livreDtos;
    }

    /**
     * Cherche les livres dont le titre contient le suite de caractère renseignée
     * @param motCle le suite de caractère, critère de recherche
     * @return la liste des livres recherchés
     */
    @Override
    public List<LivreDto> findLivreByTitreContaining(String motCle) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreDto> livreDtos = new ArrayList<>();
        List<Livre> livres = livreRepository.findLivreByTitreContaining(motCle);
            if (livres == null) {
                throw new IntrouvableException("Aucun résultat de recherche");
            } else {
                for (Livre livre : livres) {
                    livreDtos.add(modelMapper.map(livre, LivreDto.class));
                }
            }
            return livreDtos;
        }

    /**
     * Recherche de livres par auteur
     * @param auteurId l'identifiant de l'auteur
     * @return la liste des livres recherchés
     */
    @Override
    public List<LivreDto> findLivreByAuteur(Long auteurId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreDto> livreDtos = new ArrayList<>();
        List<Livre> livres = livreRepository.findLivreByAuteur(auteurId);
        if (livres == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else {
            for (Livre livre : livres) {
                livreDtos.add(modelMapper.map(livre, LivreDto.class));
            }
        }
            return livreDtos;
    }

    /**
     * Renvoie le liste des 12 derniers livres enregistrés dans la BD
     * @return le liste des 12 derniers livres
     */
    @Override
    public List<LivreDto> findLast12() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<LivreDto> livreDtos = new ArrayList<>();
        Page<Livre> livresPage = livreRepository.findLast12(PageRequest.of(0, 12, Sort.by("id").descending()));
        List<Livre> livres = livresPage.getContent();
        for (Livre livre : livres) {
            livreDtos.add(modelMapper.map(livre, LivreDto.class));
        }
        return livreDtos;
    }

    /**
     * Cherche un livre par son identifiant
     * @param livreId l'identifiant du livre
     * @return le livre recherché
     */
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
