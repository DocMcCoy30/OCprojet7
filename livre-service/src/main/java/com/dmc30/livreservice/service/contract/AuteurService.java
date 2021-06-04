package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.service.dto.livre.AuteurDto;

import java.util.List;

public interface AuteurService {

    List<AuteurDto> findAll();
    List<AuteurDto> findAuteurByLivres(Long livreId);
    List<AuteurDto> findAuteurByNomContaining(String motCle);
}
