package com.dmc30.emailservice.service.contract;

import com.dmc30.emailservice.service.bean.PretBean;

import java.util.List;

public interface EmpruntService {

    List<PretBean> findExpiredPrets();
    List<Long> findUtilisateurEnRetard();
    List<PretBean> findExpiredPretsByUtilisateurId(Long utilisateurId);
}
