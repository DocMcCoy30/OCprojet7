package com.dmc30.empruntservice.service.contract;

import com.dmc30.empruntservice.dto.CreateEmpruntDto;
import com.dmc30.empruntservice.dto.PretDto;

import java.util.List;

public interface EmpruntService {

    PretDto createEmprunt(CreateEmpruntDto createEmpruntDto);

    List<PretDto> findEmpruntEnCours(Long bibliothequeId);

    List<PretDto> findEmpruntByUtilisateurId(Long utilisateurId);

    void retournerEmprunt(Long empruntId, String ouvrageId);
}
