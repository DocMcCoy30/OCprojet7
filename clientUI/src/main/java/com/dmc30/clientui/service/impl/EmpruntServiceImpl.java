package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.bean.bibliotheque.PretBean;
import com.dmc30.clientui.proxy.EmpruntServiceProxy;
import com.dmc30.clientui.service.contract.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpruntServiceImpl implements EmpruntService {

    EmpruntServiceProxy empruntServiceProxy;

    @Autowired
    public EmpruntServiceImpl(EmpruntServiceProxy empruntServiceProxy) {
        this.empruntServiceProxy = empruntServiceProxy;
    }

    @Override
    public PretBean createEmprunt(CreateEmpruntBean createEmpruntBean) {
        return empruntServiceProxy.createEmprunt(createEmpruntBean);
    }

    @Override
    public boolean empruntExist(CreateEmpruntBean createEmpruntBean) {
        boolean verif = false;
        return false;
    }

    @Override
    public List<PretBean> getEmpruntsEnCours(Long bibliothequeId) {
        return empruntServiceProxy.findEmpruntEnCours(bibliothequeId);
    }

    @Override
    public List<PretBean> getEmpruntByUtilisateurId(Long utilisateurId) {
        return empruntServiceProxy.findEmpruntByUtilisateurId(utilisateurId);
    }
}
