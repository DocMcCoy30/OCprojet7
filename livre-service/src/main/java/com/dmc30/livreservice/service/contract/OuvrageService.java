package com.dmc30.livreservice.service.contract;

import java.util.List;

public interface OuvrageService {

    Integer findOuvrageDispoInOneBibliotheque (Long livreId, Long bibliothequeId);
    List<Object> findOuvrageDispoInOtherBibiotheque (Long livreId, Long bibliothequeId);
}
