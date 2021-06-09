package com.dmc30.empruntservice.data.repository;

import com.dmc30.empruntservice.data.entity.Ouvrage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Long> {
}