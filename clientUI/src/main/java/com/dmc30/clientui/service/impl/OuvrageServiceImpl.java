package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuvrageServiceImpl implements OuvrageService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public OuvrageServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    /**
     * Cherche le nombre d'exemplaire disponible d'un ouvrage dans la bibliothèque selectionnée
     * @param livreId l'identifiant du livre correspondant à l'ouvrage recherché
     * @param bibliothequeId l'identifiant de la bibliothèque selectionnée
     * @return le nombre d'exemplaire de l'ouvrage
     */
    @Override
    public Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOneBibliotheque(livreId,bibliothequeId);
    }

    /**
     * Cherche le nombre d'exemplaires disponibles d'un ouvrage par bibliothèque autre que la bibliothèque selectionnée par l'utilisateur
     * @param livreId l'identifiant du livre correspondant à l'ouvrage
     * @param bibliothequeId l'identifiant de la bibliothèque selectionné par l'utilisateur et non concernée par la recherche
     * @return le nombre d'exemplaire dans chaque bibliothèque, l'identifiant de la bibliothèque et son nom
     */
    @Override
    public List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOtherBibliotheque(livreId, bibliothequeId);
    }
}
