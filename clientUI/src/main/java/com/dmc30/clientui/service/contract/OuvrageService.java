package com.dmc30.clientui.service.contract;

import com.dmc30.clientui.shared.bibliotheque.CreateEmpruntDto;
import com.dmc30.clientui.shared.bibliotheque.OuvrageDto;
import com.dmc30.clientui.shared.bibliotheque.OuvrageResponseModelDto;
import com.dmc30.clientui.shared.utilisateur.UtilisateurDto;
import com.dmc30.clientui.ui.model.OuvrageResponseModel;

import java.util.List;

public interface OuvrageService {

    Integer getOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);
    List<Object> getOuvrageDispoInOtherBibliotheque(Long livreId, Long bibliothequeId);
    OuvrageResponseModelDto getOuvrageById(Long ouvrageId);
    List<OuvrageResponseModelDto> getOuvragesByIdInterne(String idInterne);
    OuvrageResponseModelDto getOuvrageByIdInterne(String idInterne);
    CreateEmpruntDto createEmpruntForm(UtilisateurDto utilisateurDto, OuvrageResponseModelDto ouvrageResponseModelDto);
}
