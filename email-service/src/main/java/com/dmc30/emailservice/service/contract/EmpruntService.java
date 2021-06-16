package com.dmc30.emailservice.service.contract;

import com.dmc30.emailservice.data.entity.PretEntity;
import com.dmc30.emailservice.service.dto.PretDto;

import java.util.List;

public interface EmpruntService {

    List<PretDto> findExpiredPrets();
    List<Long> findUtilisateurEnRetard();
    List<PretDto> findExpiredPretsByUtilisateurId(Long utilisateurId);
}
