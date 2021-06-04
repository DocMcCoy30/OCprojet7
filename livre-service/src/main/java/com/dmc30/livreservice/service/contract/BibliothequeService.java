package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.service.dto.bibliotheque.BibliothequeDto;

import java.util.List;

public interface BibliothequeService {

    List<BibliothequeDto> findAll();
    BibliothequeDto findById(Long Bibliothequeid);
}
