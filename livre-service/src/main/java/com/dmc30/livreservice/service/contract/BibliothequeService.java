package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.service.dto.bibliotheque.BibliothequeDto;
import com.dmc30.livreservice.web.exception.TechnicalException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BibliothequeService {

    ResponseEntity<?> findAll();

    ResponseEntity<?> findById(Long Bibliothequeid);

}
