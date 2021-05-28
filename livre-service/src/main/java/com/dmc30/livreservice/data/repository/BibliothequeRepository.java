package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {

    List<Bibliotheque> findAll();

    @Query("SELECT a.id, a.nom, a.code, a.numeroSiret FROM Bibliotheque a")
    List<Bibliotheque> findBibliothequeOnly();
}
