package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;

import java.util.List;

public interface OuvrageService {

    Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);
    List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId);
}
