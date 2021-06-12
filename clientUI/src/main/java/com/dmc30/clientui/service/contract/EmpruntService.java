package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.shared.bean.bibliotheque.EmpruntModelBean;
import com.dmc30.clientui.shared.bean.bibliotheque.PretBean;

import java.util.List;

public interface EmpruntService {

    PretBean createEmprunt(CreateEmpruntBean createEmpruntBean);

    boolean empruntExist(CreateEmpruntBean createEmpruntBean);

    List<PretBean> getEmpruntsEnCours(Long bibliothequeId);

    List<PretBean> getEmpruntByUtilisateurId(Long utilisateurId);

    void retournerEmprunt(Long empruntId, String ouvrageId);

    void prolongerEmprunt(Long empruntId);
}
