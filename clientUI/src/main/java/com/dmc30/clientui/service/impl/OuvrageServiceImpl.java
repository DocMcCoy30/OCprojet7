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

    @Override
    public Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOneBibliotheque(livreId,bibliothequeId);
    }

    @Override
    public List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId) {
        return livreServiceProxy.getOuvrageDispoInOtherBibliotheque(livreId, bibliothequeId);
    }
}
