package com.dmc30.emailservice.service.impl;

import com.dmc30.emailservice.proxy.EmpruntServiceProxy;
import com.dmc30.emailservice.service.bean.PretBean;
import com.dmc30.emailservice.service.contract.EmpruntService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    EmpruntServiceProxy empruntServiceProxy;

    @Autowired
    public EmpruntServiceImpl(EmpruntServiceProxy empruntServiceProxy) {
        this.empruntServiceProxy = empruntServiceProxy;
    }

    @Override
    public List<PretBean> findExpiredPrets() {
        List<PretBean> pretBeans = empruntServiceProxy.findExpiredPrets();
        return pretBeans;
    }

    @Override
    public List<Long> findUtilisateurEnRetard() {
        return empruntServiceProxy.findUtilisateurEnRetard();
    }

    @Override
    public List<PretBean> findExpiredPretsByUtilisateurId(Long utilisateurId) {
        List<PretBean> pretBeans = empruntServiceProxy.findExpiredPretsByUtilisateurId(utilisateurId);
        return pretBeans;
    }
}
