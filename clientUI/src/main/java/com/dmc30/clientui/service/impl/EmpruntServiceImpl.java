package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.proxy.EmpruntServiceProxy;
import com.dmc30.clientui.service.contract.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    EmpruntServiceProxy empruntServiceProxy;

    @Autowired
    public EmpruntServiceImpl(EmpruntServiceProxy empruntServiceProxy) {
        this.empruntServiceProxy = empruntServiceProxy;
    }

    @Override
    public void createEmprunt(CreateEmpruntBean createEmpruntBean) {
        empruntServiceProxy.createEmprunt(createEmpruntBean);
    }
}
