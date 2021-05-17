package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreServiceImpl implements LivreService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public LivreServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    @Override
    public List<LivreDto> getLivres() {
        return livreServiceProxy.getLivres();
    }

    @Override
    public List<LivreDto> get12LastLivres() {
        return livreServiceProxy.get12LastLivres();
    }

    @Override
    public List<LivreDto> getLivreByTitre(String motCle) {
        return livreServiceProxy.getLivreByTitre(motCle);
    }

    @Override
    public List<LivreDto> getLivreByAuteur(String motCle) {
        return livreServiceProxy.getLivreByAuteur(motCle);
    }
}
