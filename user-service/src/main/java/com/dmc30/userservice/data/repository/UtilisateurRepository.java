package com.dmc30.userservice.data.repository;

import com.dmc30.userservice.data.entity.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {

    UtilisateurEntity findByEmail(String email);

    UtilisateurEntity findByPublicId(String publicId);

    UtilisateurEntity findByUsername(String username);
}
