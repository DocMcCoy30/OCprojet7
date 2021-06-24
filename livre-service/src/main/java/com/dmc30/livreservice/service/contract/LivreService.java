package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.service.dto.livre.LivreDto;
import com.dmc30.livreservice.web.exception.TechnicalException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LivreService {

    List<LivreDto> findAll();
    List<LivreDto> findLivreByTitreContaining(String motCle);
    List<LivreDto> findLivreByAuteur(Long auteurId);
    List<LivreDto> findLast12();
    ResponseEntity<?> findLivreById(Long livreId) ;
}
