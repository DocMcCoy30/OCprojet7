package com.dmc30.livreservice.service.contract;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;

import java.util.List;

public interface BibliothequeService {

    List<Bibliotheque> findAll();
    Bibliotheque findById(Long Bibliothequeid);
}
