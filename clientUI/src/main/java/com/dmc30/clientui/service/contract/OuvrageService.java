package com.dmc30.clientui.service.contract;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OuvrageService {

    public Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);

    public List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId);
}
