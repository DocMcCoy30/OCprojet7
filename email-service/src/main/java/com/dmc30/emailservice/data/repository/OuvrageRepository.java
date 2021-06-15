package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.OuvrageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrageRepository extends JpaRepository<OuvrageEntity, Long> {

    OuvrageEntity getById(Long ouvrageId);
}
