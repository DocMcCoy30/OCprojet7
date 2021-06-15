package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {

    @Override
    UtilisateurEntity getById(Long utilisateurId);
}
