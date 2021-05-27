package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.livre.Livre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    List<Livre> findAll();

    Livre findLivreById(Long livreId);

    @Query(value = "SELECT * FROM livre WHERE (titre) ILIKE '%' || ?1 || '%'", nativeQuery = true)
    List<Livre> findLivreByTitreContaining(String motCle);

    @Query(value = "SELECT * FROM livre JOIN many_livre_has_many_auteur mlhma on livre.id = mlhma.id_livre where mlhma.id_auteur = ?1"
            , nativeQuery = true)
    List<Livre> findLivreByAuteur(Long auteurId);

    @Query(value = "SELECT * FROM livre", nativeQuery = true)
    Page<Livre> findLast12(PageRequest id);

}
