package com.dmc30.userapi.data.repository;

import com.dmc30.userapi.data.entity.AbonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbonneRepository extends JpaRepository<AbonneEntity, Long> {

    AbonneEntity findByEmail(String email);
}
