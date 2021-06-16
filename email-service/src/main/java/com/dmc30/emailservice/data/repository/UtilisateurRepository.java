package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {

    @Override
    Optional<UtilisateurEntity> findById(Long utilisateurId);
}
