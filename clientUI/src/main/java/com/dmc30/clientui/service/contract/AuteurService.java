package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.service.dto.livre.AuteurDto;

import java.util.List;

public interface AuteurService {

    List<AuteurDto> getAuteurByNomContaining(String motCle);
}
