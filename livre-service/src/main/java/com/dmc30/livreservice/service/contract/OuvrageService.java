package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.shared.bibliotheque.OuvrageDto;
import com.dmc30.livreservice.shared.livre.LivreDto;

import java.util.List;

public interface OuvrageService {

    Integer findOuvrageDispoInOneBibliotheque (Long livreId, Long bibliothequeId);
    List<Object> findOuvrageDispoInOtherBibiotheque (Long livreId, Long bibliothequeId);
    List<OuvrageDto> findOuvrageDispoByLivreId(Long livreId, Long bibliothequeId);
    OuvrageDto findouvrageByIdInterne(String idInterne);
    List<OuvrageDto> findOuvragesByIdInterne(String idInterne);
    OuvrageDto findOuvrageById(Long ouvrageId);
    Long findLivreIdByOuvrageId(Long ouvrageId);

}
