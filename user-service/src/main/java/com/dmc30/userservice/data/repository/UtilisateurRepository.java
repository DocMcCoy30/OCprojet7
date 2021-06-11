package com.dmc30.userservice.data.repository;

import com.dmc30.userservice.data.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {

    @Query(value = "SELECT * FROM utilisateur WHERE id=?1", nativeQuery = true)
    UtilisateurEntity findUtilisateurById(Long id);

    UtilisateurEntity findByEmail(String email);

    UtilisateurEntity findByPublicId(String publicId);

    UtilisateurEntity findByUsername(String username);

    @Query(value = "SELECT * FROM utilisateur WHERE (numero_abonne) = ?1", nativeQuery = true)
    UtilisateurEntity findUtilisateurByNumAbonne(String numAbonne);

    @Query(value = "SELECT * FROM utilisateur WHERE (numero_abonne) ILIKE '%' || ?1 || '%'", nativeQuery = true)
    List<UtilisateurEntity> findUtilisateursByNumAbonne(String numAbonne);

}
