package com.dmc30.empruntservice.service.contract;

import com.dmc30.empruntservice.dto.CreateEmpruntDto;
import com.dmc30.empruntservice.dto.PretDto;
import org.springframework.http.ResponseEntity;

public interface EmpruntService {

    PretDto createEmprunt(CreateEmpruntDto createEmpruntDto);
}
