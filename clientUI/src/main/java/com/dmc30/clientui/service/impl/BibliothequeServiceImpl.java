package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.shared.bibliotheque.BibliothequeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public BibliothequeServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    @Override
    public List<BibliothequeDto> getBibliotheques() {
        return livreServiceProxy.getBibliotheques();
    }

    /**
     * Recherche d'une bibliothèque par son identifiant
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return la bibliothèque recherchée
     */
    @Override
    public BibliothequeDto getBibliotheque(Long bibliothequeId) {
        return livreServiceProxy.getBibliotheque(bibliothequeId);
    }

}
