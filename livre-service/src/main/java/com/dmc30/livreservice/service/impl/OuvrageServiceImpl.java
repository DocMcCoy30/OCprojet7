package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import com.dmc30.livreservice.data.repository.OuvrageRepository;
import com.dmc30.livreservice.service.contract.OuvrageService;
import com.dmc30.livreservice.service.dto.bibliotheque.OuvrageDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {

    OuvrageRepository ouvrageRepository;

    @Autowired
    public OuvrageServiceImpl(OuvrageRepository ouvrageRepository) {
        this.ouvrageRepository = ouvrageRepository;
    }

    /**
     * Recherche le nombre d'exemplaire disponible d'un ouvrage dans la bibliotheque selectionnée
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return le nombre d'exemplaire
     */
    @Override
    public Integer findOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) {
        return ouvrageRepository.findOuvrageDispoInOneBibliotheque(livreId, bibliothequeId);
    }

    /**
     * Recherche le nombre d'exemplaire disponible d'un ouvrage dans les autres bibliotheques que celle selectionnée
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return
     */
    @Override
    public List<Object> findOuvrageDispoInOtherBibiotheque(Long livreId, Long bibliothequeId) {
        return ouvrageRepository.findOuvrageDispoInOtherBibiotheque(livreId, bibliothequeId);
    }

    /**
     * Recherche les ouvrages (exemplaires) d'un livre dans une bibliothèque selectionné
     * @param livreId l'identifiant du livre
     * @param bibliothequeId l'identifiant de la bibliothèque
     * @return la liste des ouvrages
     */
    @Override
    public List<OuvrageDto> findOuvrageDispoByLivreId(Long livreId, Long bibliothequeId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<OuvrageDto> ouvrageDtos = new ArrayList<>();
        List<Ouvrage> ouvrages = ouvrageRepository.findOuvrageDispoByLivreId(livreId, bibliothequeId);
        for (Ouvrage ouvrage: ouvrages) {
            ouvrageDtos.add(modelMapper.map(ouvrage, OuvrageDto.class));
        }
        return ouvrageDtos;
    }

    /**
     * Cherche un ouvrage selon l'identifiant interne renseigné dans la vue
     * @param idInterne l'identifiant interne (complet)
     * @return la liste des ouvrages correspondants
     */
    @Override
    public OuvrageDto findouvrageByIdInterne(String idInterne) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ouvrage ouvrage = ouvrageRepository.findOuvrageByIdInterne(idInterne);
        return modelMapper.map(ouvrage, OuvrageDto.class);
    }

    /**
     * Cherche une liste d'ouvrage selon l'identifiant interne renseigné dans la vue
     * @param idInterne l'identifiant interne (partiel ou complet)
     * @return la liste des ouvrages correspondants
     */
    @Override
    public List<OuvrageDto> findOuvragesByIdInterne(String idInterne) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<OuvrageDto> ouvrageDtos = new ArrayList<>();
        List<Ouvrage> ouvrages = ouvrageRepository.findOuvragesByIdInterne(idInterne);
        for (Ouvrage ouvrage: ouvrages) {
            ouvrageDtos.add(modelMapper.map(ouvrage, OuvrageDto.class));
        }
        return ouvrageDtos;
    }

    /**
     * Cherche un ouvrage par son identifiant
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return l'ouvrage recherché
     */
    @Override
    public OuvrageDto findOuvrageById(Long ouvrageId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Ouvrage ouvrage = ouvrageRepository.findOuvrageById(ouvrageId);
        OuvrageDto ouvrageDto = modelMapper.map(ouvrage, OuvrageDto.class);
        return ouvrageDto;
    }

    /**
     * Cherche un livre en fonction de l'identifiant d'un ouvrage
     * @param ouvrageId l'identifiant de l'ouvrage
     * @return le livre recherché
     */
    @Override
    public Long findLivreIdByOuvrageId(Long ouvrageId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Long livreId = ouvrageRepository.findLivreByOuvrageId(ouvrageId);
        return livreId;
    }
}
