package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.bibliotheque.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {

    @Query(value = "SELECT count(*) FROM ouvrage WHERE ouvrage.emprunte = false AND ouvrage.id_livre = ?1 AND ouvrage.id_bibliotheque = ?2", nativeQuery = true)
    Integer findOuvrageDispoInOneBibliotheque(Long livreId, Long bibliothequeId);

    @Query(value = "SELECT count(*), ouvrage.id_bibliotheque, bibliotheque.nom FROM ouvrage JOIN bibliotheque ON ouvrage.id_bibliotheque = bibliotheque.id WHERE ouvrage.emprunte = false AND ouvrage.id_livre = ?1 AND ouvrage.id_bibliotheque != ?2 GROUP BY ouvrage.id_bibliotheque, bibliotheque.nom", nativeQuery = true)
    List<Object> findOuvrageDispoInOtherBibiotheque(Long livreId, Long bibliothequeId);

    @Query(value = "SELECT * FROM ouvrage WHERE ouvrage.emprunte = false AND ouvrage.id_livre = ?1 AND ouvrage.id_bibliotheque = ?2", nativeQuery = true)
    List<Ouvrage> findOuvrageDispoByLivreId(Long LivreId, Long BibliothequeId);

    Ouvrage findOuvrageByIdInterne(String idInterne);

    @Query(value = "SELECT * FROM ouvrage WHERE (id_interne) ILIKE '%' || ?1 || '%'", nativeQuery = true)
    List<Ouvrage> findOuvragesByIdInterne(String idInterne);

    Ouvrage findOuvrageById(Long ouvrageId);

    @Query(value = "SELECT id_livre FROM ouvrage WHERE id=?1", nativeQuery = true)
    Long findLivreByOuvrageId(Long ouvrageId);
}

