package com.dmc30.livreservice.data.repository;

import com.dmc30.livreservice.data.entity.bibliotheque.Bibliotheque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliothequeRepository extends JpaRepository<Bibliotheque, Long> {


}
