package com.dmc30.livreservice.service.impl;

import com.dmc30.livreservice.data.repository.OuvrageRepository;
import com.dmc30.livreservice.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
