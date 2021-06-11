package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.EmpruntModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.PretBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.proxy.EmpruntServiceProxy;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;
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

    @Override
    public void retournerEmprunt(Long empruntId, String ouvrageId) {
        empruntServiceProxy.retournerEmprunt(empruntId, ouvrageId);
    }

}
