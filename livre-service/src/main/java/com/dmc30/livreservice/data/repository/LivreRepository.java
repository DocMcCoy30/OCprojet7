package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.livre.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    @Query(value = "SELECT * FROM livre WHERE LOWER (titre) LIKE '%' || ?1 || '%'",nativeQuery = true)
    List<Livre> findLivreByTitreContaining(String motCle);

    @Query(value = "SELECT * FROM livre JOIN many_livre_has_many_auteur mlhma on livre.id = mlhma.id_livre where mlhma.id_auteur = ?1"
            , nativeQuery = true)
    List<Livre> findLivreByAuteur(Long auteurId);
}
