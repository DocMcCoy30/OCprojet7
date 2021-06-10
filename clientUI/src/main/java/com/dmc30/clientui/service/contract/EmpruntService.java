package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.bean.bibliotheque.CreateEmpruntBean;
import com.dmc30.clientui.bean.bibliotheque.EmpruntModelBean;
import com.dmc30.clientui.bean.bibliotheque.PretBean;

import java.util.List;

public interface EmpruntService {

    PretBean createEmprunt(CreateEmpruntBean createEmpruntBean);

    boolean empruntExist(CreateEmpruntBean createEmpruntBean);

    List<PretBean> getEmpruntsEnCours(Long bibliothequeId);

    List<PretBean> getEmpruntByUtilisateurId(Long utilisateurId);
}
