package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.LivreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<LivreEntity, Long> {

    LivreEntity getById(Long livreId);
}
