package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.data.entity.livre.Auteur;
import com.dmc30.livreservice.shared.livre.AuteurDto;

import java.util.List;

public interface AuteurService {

    List<AuteurDto> findAll();
    List<AuteurDto> findAuteurByNomOrPrenom(String nom, String prenom);
    List<AuteurDto> findAuteurByLivres(Long livreId);
    List<AuteurDto> findAuteurByNomContaining(String motCle);
}
