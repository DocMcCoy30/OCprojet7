package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.OuvrageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OuvrageRepository extends JpaRepository<OuvrageEntity, Long> {

    Optional<OuvrageEntity> findById(Long ouvrageId);
}
