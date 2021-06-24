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
     *
     * @return la liste
     */
    @Override
    public ResponseEntity<?> getBibliotheques() {
        try {
            ResponseEntity<?> response = livreServiceProxy.getBibliotheques();
            return response;
        } catch (FeignException e) {
            ResponseEntity<?> response = ResponseEntity.status(ErrorMessage.TECHNICAL_ERROR.getErrorCode())
                    .body(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
            return response;
        }
    }

    /**
     * Recherche d'une bibliothèque par son identifiant
     *
     * @param bibliothequeId l'identifiant de la bibliotheque
     * @return la bibliothèque recherchée
     */
    @Override
    public ResponseEntity<?> getBibliothequeById(Long bibliothequeId) {
        System.out.println("into getBibliothequeById");
        try {
            ResponseEntity<?> response = livreServiceProxy.getBibliothequeById(bibliothequeId);
            return response;
        } catch (FeignException e) {
            ResponseEntity<?> response = null;
            if (e.status() == 491) {
                response = ResponseEntity.status(ErrorMessage.INTROUVABLE_EXCEPTION.getErrorCode())
                        .body(ErrorMessage.INTROUVABLE_EXCEPTION.getErrorMessage());
            } else if (e.status() == 490) {
                response = ResponseEntity.status(ErrorMessage.TECHNICAL_ERROR.getErrorCode())
                        .body(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
            }
            return response;
        }
    }

}
