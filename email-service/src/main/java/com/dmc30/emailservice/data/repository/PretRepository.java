package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.PretEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PretRepository extends JpaRepository<PretEntity, Long> {

    @Query(value = "(select * from pret where restitution = false " +
            "and date_restitution < now() group by id_utilisateur, id) UNION " +
            "(select * from pret where restitution = false " +
            "and prolongation = true and date_prolongation < now()group by id_utilisateur, id)",
            nativeQuery = true)
    List<PretEntity> findExpiredPrets();
}

