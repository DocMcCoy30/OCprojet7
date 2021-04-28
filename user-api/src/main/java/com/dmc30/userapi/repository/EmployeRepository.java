package com.dmc30.userapi.repository;

import com.dmc30.userapi.model.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
}
