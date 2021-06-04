package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.web.exception.IntrouvableException;
import com.dmc30.livreservice.data.entity.livre.Auteur;
import com.dmc30.livreservice.data.repository.AuteurRepository;
import com.dmc30.livreservice.service.contract.AuteurService;
import com.dmc30.livreservice.service.dto.livre.AuteurDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuteurServiceImpl implements AuteurService {

    AuteurRepository auteurRepository;

    @Autowired
    public AuteurServiceImpl(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    /**
     * Recherche tous les auteur dans la BD
     * @return la liste de tous les auteurs enregistrés
     */
    @Override
    public List<AuteurDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AuteurDto>auteurDtos = new ArrayList<>();
        List<Auteur> auteurs = auteurRepository.findAll();
        if (auteurs.isEmpty()) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else {
            for (Auteur auteur:auteurs) {
                auteurDtos.add(modelMapper.map(auteur, AuteurDto.class));
            }
        }
        return auteurDtos;
    }

    /**
     * Cherche les auteurs d'un livre
     * @param livreId l'identifiant du livre
     * @return les auteurs du livre
     */
    @Override
    public List<AuteurDto> findAuteurByLivres(Long livreId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AuteurDto>auteurDtos = new ArrayList<>();
        List<Auteur> auteurs = auteurRepository.findAuteurByLivres(livreId);
        for (Auteur auteur:auteurs) {
            auteurDtos.add(modelMapper.map(auteur, AuteurDto.class));
        }
        return auteurDtos;
    }

    /**
     * Cherche un auteur dont le nom contient la suite de caractère renseignée
     * @param motCle la suite de caractère, critère de recherche
     * @return la liste des auteurs recherchés
     */
    @Override
    public List<AuteurDto> findAuteurByNomContaining(String motCle) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AuteurDto>auteurDtos = new ArrayList<>();
        List<Auteur> auteurs = auteurRepository.findAuteurByNomContaining(motCle);
        for (Auteur auteur:auteurs) {
            auteurDtos.add(modelMapper.map(auteur, AuteurDto.class));
        }
        return auteurDtos;
    }

}
