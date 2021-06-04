package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.service.dto.bibliotheque.CreateEmpruntDto;
import com.dmc30.clientui.service.dto.bibliotheque.OuvrageResponseModelDto;
import com.dmc30.clientui.service.dto.utilisateur.UtilisateurDto;

import java.util.List;

public interface OuvrageService {

    Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);
    List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId);
    OuvrageResponseModelDto getOuvrageById(Long ouvrageId);
    List<OuvrageResponseModelDto> getOuvragesByIdInterne(String idInterne);
    OuvrageResponseModelDto getOuvrageByIdInterne(String idInterne);
    CreateEmpruntDto createEmpruntForm(UtilisateurDto utilisateurDto, OuvrageResponseModelDto ouvrageResponseModelDto);
}
