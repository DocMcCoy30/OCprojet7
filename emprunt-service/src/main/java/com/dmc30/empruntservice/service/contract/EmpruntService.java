package com.dmc30.empruntservice.service.contract;

import com.dmc30.empruntservice.service.dto.CreateEmpruntDto;
import com.dmc30.empruntservice.service.dto.PretDto;

import java.util.List;

public interface EmpruntService {

    PretDto createEmprunt(CreateEmpruntDto createEmpruntDto);

    List<PretDto> findEmpruntEnCours(Long bibliothequeId);

    List<PretDto> findEmpruntByUtilisateurId(Long utilisateurId);

    void retournerEmprunt(Long empruntId, String ouvrageId);

    void prolongerEmprunt(Long empruntId);

    List<PretDto> findExpiredPrets();

    List<PretDto> findExpiredPretsByUtilisateurId(Long utilisateurId);

    List<Long> findUtilisateurEnRetard();
}
