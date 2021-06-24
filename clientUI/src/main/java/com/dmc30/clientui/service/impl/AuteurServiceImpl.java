package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.proxy.LivreServiceProxy;
import com.dmc30.clientui.service.contract.AuteurService;
import com.dmc30.clientui.shared.bean.livre.AuteurBean;
import com.dmc30.clientui.web.exception.ErrorMessage;
import com.dmc30.clientui.web.exception.TechnicalException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuteurServiceImpl implements AuteurService {

    LivreServiceProxy livreServiceProxy;

    @Autowired
    public AuteurServiceImpl(LivreServiceProxy livreServiceProxy) {
        this.livreServiceProxy = livreServiceProxy;
    }

    @Override
    public List<AuteurBean> getAuteurs() throws TechnicalException {
        List<AuteurBean> auteurs = new ArrayList<>();
        try {
            auteurs = livreServiceProxy.getAuteurs();
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return auteurs;
    }

    @Override
    public List<AuteurBean> getAuteurByNomContaining(String motCle) throws TechnicalException {
        List<AuteurBean> auteurs = new ArrayList<>();
        try {
            auteurs = livreServiceProxy.getAuteurByNomContaining(motCle);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return auteurs;
    }
}
