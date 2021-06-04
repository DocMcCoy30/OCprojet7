package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.livre.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {

    Auteur findAuteurById(Long id);

    @Query(value = "SELECT * FROM auteur", nativeQuery = true)
    List<Auteur> findAll();

    @Query(value = "SELECT a.* FROM auteur a INNER JOIN many_livre_has_many_auteur al ON al.id_auteur=a.id WHERE al.id_livre=?1", nativeQuery = true)
    List<Auteur> findAuteurByLivres(@Param("id") Long id);

    @Query(value = "SELECT * FROM auteur WHERE (nom) ILIKE  '%' || ?1 || '%' OR (prenom) ILIKE '%' || ?1 || '%';",nativeQuery = true)
    List<Auteur> findAuteurByNomContaining(String motCle);
}
