package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;
import com.dmc30.livreservice.data.entity.livre.Auteur;
import com.dmc30.livreservice.data.repository.BibliothequeRepository;
import com.dmc30.livreservice.exception.IntrouvableException;
import com.dmc30.livreservice.service.contract.BibliothequeService;
import com.dmc30.livreservice.shared.bibliotheque.BibliothequeDto;
import com.dmc30.livreservice.shared.livre.AuteurDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BibliothequeDto> findAll() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<BibliothequeDto> bibliothequeDtos = new ArrayList<>();
        List<Bibliotheque> bibliotheques = bibliothequeRepository.findAll();
        if (bibliotheques == null) {
            throw new IntrouvableException("Aucun résultat de recherche");
        } else {
            for (Bibliotheque bibliotheque : bibliotheques) {
                bibliothequeDtos.add(modelMapper.map(bibliotheque, BibliothequeDto.class));
            }
        }
        return bibliothequeDtos;
    }


    /**
     * Cherche un objet bibliothèque dans la BD par son identifiant. Si l'identifiant n'est pas précisé, renvoie la 1ère bibliothèque enregistrée.
     * @param bibliothequeid L'identifiant de la bibliothèque rcherchée
     * @return un objet bibliothèque
     */
    @Override
    public BibliothequeDto findById(Long bibliothequeid) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Bibliotheque bibliotheque = new Bibliotheque();
        if (bibliothequeid==null) {
            bibliothequeid = 1L;
        }
        Optional<Bibliotheque> result = bibliothequeRepository.findById(bibliothequeid);
        if (result.isPresent()) {
            bibliotheque = result.get();
        }
        BibliothequeDto bibliothequeDto = modelMapper.map(bibliotheque, BibliothequeDto.class);
        return bibliothequeDto;
    }
}
