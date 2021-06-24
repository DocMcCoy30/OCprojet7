package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;
import com.dmc30.clientui.web.exception.TechnicalException;

import java.util.List;

public interface OuvrageService {

    Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId) throws TechnicalException;
    List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId) throws TechnicalException;
    OuvrageResponseModelBean getOuvrageById(Long ouvrageId) throws TechnicalException;
    List<OuvrageResponseModelBean> getOuvragesByIdInterne(String idInterne) throws TechnicalException;
    OuvrageResponseModelBean getOuvrageByIdInterne(String idInterne) throws TechnicalException;
}
