package com.dmc30.emailservice.data.repository;

import com.dmc30.emailservice.data.entity.PretEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PretRepository extends JpaRepository<PretEntity, Long> {

    @Query(value = "(select * from pret where restitution = false " +
            "and date_restitution < now() group by id_utilisateur, id) UNION " +
            "(select * from pret where restitution = false " +
            "and prolongation = true and date_prolongation < now()group by id_utilisateur, id) " +
            "order by id_utilisateur",
            nativeQuery = true)
    List<PretEntity> findExpiredPrets();

    @Query(value = "(select id_utilisateur from pret where restitution = false " +
            "and date_restitution < now() group by id_utilisateur, id) UNION " +
            "(select id_utilisateur from pret where restitution = false " +
            "and prolongation = true and date_prolongation < now()group by id_utilisateur, id) " +
            "order by id_utilisateur",
            nativeQuery = true)
    List<Long> findUtilisateurEnRetard();

    @Query(value = "(select * from pret where restitution = false " +
            "and date_restitution < now() and id_utilisateur=?1) UNION " +
            "(select * from pret where restitution = false " +
            "and prolongation = true and date_prolongation < now() " +
            "and id_utilisateur=?1)",
            nativeQuery = true)
    List<PretEntity> findExpiredPretsByUtilisateurId(Long utilisateurId);
}

