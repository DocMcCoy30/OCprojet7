package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.EmpruntModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.PretBean;
import com.dmc30.clientui.web.exception.TechnicalException;

import java.util.List;

public interface EmpruntService {

    PretBean createEmprunt(CreateEmpruntBean createEmpruntBean) throws TechnicalException;

    List<PretBean> getEmpruntsEnCours(Long bibliothequeId) throws TechnicalException;

    List<PretBean> getEmpruntByUtilisateurId(Long utilisateurId) throws TechnicalException;

    void retournerEmprunt(Long empruntId, String ouvrageId) throws TechnicalException;

    void prolongerEmprunt(Long empruntId) throws TechnicalException;
}
