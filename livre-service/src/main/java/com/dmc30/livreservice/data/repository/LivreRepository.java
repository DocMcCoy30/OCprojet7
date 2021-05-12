package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.livre.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findLivreByTitreContaining(String motCle);
}
