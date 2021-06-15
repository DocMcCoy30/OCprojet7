package com.dmc30.emailservice.service.contract;

import com.dmc30.emailservice.service.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    List<UtilisateurDto> findAll();
    UtilisateurDto findById(Long utilisateurId);
}
