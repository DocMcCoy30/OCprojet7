package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.livre.LivreDto;
import com.dmc30.clientui.proxy.LivreApiProxy;
import com.dmc30.clientui.service.contract.ClientUILivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientUILivreServiceImpl implements ClientUILivreService {

    LivreApiProxy livreApiProxy;

    @Autowired
    public ClientUILivreServiceImpl(LivreApiProxy livreApiProxy) {
        this.livreApiProxy = livreApiProxy;
    }

    @Override
    public List<LivreDto> getLivres() {
        return livreApiProxy.getLivres();
    }

    @Override
    public List<LivreDto> getLivreByTitre(String motCle) {
        return livreApiProxy.getLivreByTitre(motCle);
    }
}
