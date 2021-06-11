package com.dmc30.empruntservice.data.repository;

import com.dmc30.empruntservice.data.entity.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {

    @Query(value = "SELECT * FROM ouvrage WHERE id_interne=?1", nativeQuery = true)
    Optional<Ouvrage> findByIdInterne(String ouvrageId);
}