package com.dmc30.userapi.repository;

import com.dmc30.userapi.model.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

    @Query(value = "SELECT MAX(id) FROM adresse", nativeQuery = true)
    Integer findMaxId();
}
