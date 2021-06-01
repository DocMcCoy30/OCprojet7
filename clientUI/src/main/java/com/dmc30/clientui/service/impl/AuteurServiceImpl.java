package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.AuteurService;
import com.dmc30.clientui.shared.livre.AuteurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuteurServiceImpl implements AuteurService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public AuteurServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    @Override
    public List<AuteurDto> getAuteurByNomContaining(String motCle) {
        return livreServiceProxy.getAuteurByNomContaining(motCle);
    }
}
