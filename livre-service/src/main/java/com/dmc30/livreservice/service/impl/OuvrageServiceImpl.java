package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import com.dmc30.livreservice.data.repository.OuvrageRepository;
import com.dmc30.livreservice.service.contract.OuvrageService;
import com.dmc30.livreservice.shared.bibliotheque.OuvrageDto;
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
}
