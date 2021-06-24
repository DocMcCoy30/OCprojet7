package com.dmc30.clientui.service.impl;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.EmpruntModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.PretBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.proxy.EmpruntServiceProxy;
import com.dmc30.clientui.service.contract.EmpruntService;
import com.dmc30.clientui.service.contract.OuvrageService;
import com.dmc30.clientui.web.exception.ErrorMessage;
import com.dmc30.clientui.web.exception.TechnicalException;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
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
    public PretBean createEmprunt(CreateEmpruntBean createEmpruntBean) throws TechnicalException {
        PretBean pretBean = new PretBean();
        try {
            pretBean = empruntServiceProxy.createEmprunt(createEmpruntBean);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return pretBean;
    }

    @Override
    public List<PretBean> getEmpruntsEnCours(Long bibliothequeId) throws TechnicalException {
        List<PretBean> pretBeanList = new ArrayList<>();
        try {
            pretBeanList = empruntServiceProxy.findEmpruntEnCours(bibliothequeId);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return pretBeanList;
    }

    @Override
    public List<PretBean> getEmpruntByUtilisateurId(Long utilisateurId) throws TechnicalException {
        List<PretBean> pretBeanList = new ArrayList<>();
        try {
            pretBeanList = empruntServiceProxy.findEmpruntByUtilisateurId(utilisateurId);
        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
        return pretBeanList;
    }


    @Override
    public void retournerEmprunt(Long empruntId, String ouvrageId) throws TechnicalException {
        try {
            empruntServiceProxy.retournerEmprunt(empruntId, ouvrageId);

        } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
    }

    @Override
    public void prolongerEmprunt(Long empruntId) throws TechnicalException {
        try {
        empruntServiceProxy.prolongerEmprunt(empruntId);
    } catch (FeignException e) {
            throw new TechnicalException(ErrorMessage.TECHNICAL_ERROR.getErrorMessage());
        }
    }
}
