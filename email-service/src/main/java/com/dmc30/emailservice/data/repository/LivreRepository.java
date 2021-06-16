package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.LivreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivreRepository extends JpaRepository<LivreEntity, Long> {

    Optional<LivreEntity> findById(Long livreId);
}
