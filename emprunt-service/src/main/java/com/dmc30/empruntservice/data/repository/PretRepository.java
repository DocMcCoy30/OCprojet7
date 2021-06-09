package com.dmc30.empruntservice.data.repository;

import com.dmc30.empruntservice.data.entity.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PretRepository extends JpaRepository<Pret, Long> {
}