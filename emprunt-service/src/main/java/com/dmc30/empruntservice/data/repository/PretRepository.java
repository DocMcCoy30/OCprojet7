package com.dmc30.empruntservice.data.repository;

import com.dmc30.empruntservice.data.entity.Pret;
import com.dmc30.empruntservice.dto.PretDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Long> {

    @Query(value = "SELECT * FROM pret WHERE id_utilisateur=?1", nativeQuery = true)
    List<Pret> findEmpruntByUtilisateurId(Long utilisateurId);
}