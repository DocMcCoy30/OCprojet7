package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.OuvrageResponseModelBean;
import com.dmc30.clientui.shared.bean.utilisateur.UtilisateurBean;

import java.util.List;

public interface OuvrageService {

    Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);
    List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId);
    OuvrageResponseModelBean getOuvrageById(Long ouvrageId);
    List<OuvrageResponseModelBean> getOuvragesByIdInterne(String idInterne);
    OuvrageResponseModelBean getOuvrageByIdInterne(String idInterne);
}
