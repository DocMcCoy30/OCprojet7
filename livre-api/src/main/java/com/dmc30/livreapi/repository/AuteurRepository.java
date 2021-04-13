package com.dmc30.livreapi.repository;

import com.dmc30.livreapi.model.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {

    List<Auteur> findAuteurByNomOrPrenom(String nom, String prenom);
    Auteur findAuteurById(int id);

    @Query(value = "SELECT a.* FROM auteur a INNER JOIN auteurs_livres al ON al.id_auteur=a.id WHERE al.id_livre=?1", nativeQuery = true)
    List<Auteur> findAuteurByLivres(@Param("id") int id);
}
