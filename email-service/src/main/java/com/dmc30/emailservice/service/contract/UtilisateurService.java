package com.dmc30.emailservice.service.contract;

import com.dmc30.emailservice.service.bean.UtilisateurBean;

import java.util.List;

public interface UtilisateurService {

    List<UtilisateurBean> findAll();
    UtilisateurBean findUtilisateurById(Long utilisateurId);
}
