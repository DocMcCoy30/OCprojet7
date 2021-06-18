package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.BibliothequeService;
import com.dmc30.clientui.shared.bean.bibliotheque.BibliothequeBean;
import com.dmc30.clientui.web.exception.ErrorMessage;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliothequeServiceImpl implements BibliothequeService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public BibliothequeServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    /**
     * Cherche la liste de toutes les bibliotheques
     * @return la liste
     */
    @Override
    public ResponseEntity<?> getBibliotheques() {
        try {
            ResponseEntity<?> response = livreServiceProxy.getBibliotheques();
            return response;
        } catch (FeignException.FeignClientException e) {
            ResponseEntity<?> responseEntity = ResponseEntity.status(ErrorMessage.TECHNICAL_ERROR.getErrorCode())
                    .body(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
            return responseEntity;
        }
    }

    /**
     * Recherche d'une bibliothèque par son identifiant
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return la bibliothèque recherchée
     */
    @Override
    public BibliothequeBean getBibliothequeById(Long bibliothequeId) {
        return livreServiceProxy.getBibliothequeById(bibliothequeId);
    }

}
