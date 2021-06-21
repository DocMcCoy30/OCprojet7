package com.dmc30.empruntservice.data.repository;

import com.dmc30.empruntservice.data.entity.Pret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PretRepository extends JpaRepository<Pret, Long> {

    @Query(value = "SELECT * FROM pret WHERE id_utilisateur=?1", nativeQuery = true)
    List<Pret> findEmpruntByUtilisateurId(Long utilisateurId);

    @Query(value = "(select * from pret where restitution = false " +
            "and date_restitution < now() group by id_utilisateur, id) UNION " +
            "(select * from pret where restitution = false " +
            "and prolongation = true and date_prolongation < now()group by id_utilisateur, id) " +
            "order by id_utilisateur",
            nativeQuery = true)
    List<Pret> findExpiredPrets();

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
    List<Pret> findExpiredPretsByUtilisateurId(Long utilisateurId);
}