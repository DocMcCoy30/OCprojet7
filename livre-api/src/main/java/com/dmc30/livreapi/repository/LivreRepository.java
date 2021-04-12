package com.dmc30.livreapi.repository;

import com.dmc30.livreapi.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Integer> {

    List<Livre> findLivreByTitreContaining(String motCle);
}
