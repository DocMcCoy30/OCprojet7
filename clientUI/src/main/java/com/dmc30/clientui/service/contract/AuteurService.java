package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.livre.AuteurDto;

import java.util.List;

public interface AuteurService {

    List<AuteurDto> getAuteurByNomContaining(String motCle);
}
