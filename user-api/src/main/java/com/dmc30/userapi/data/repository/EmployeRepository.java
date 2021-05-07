package com.dmc30.userapi.data.repository;

import com.dmc30.userapi.data.entity.EmployeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<EmployeEntity, Long> {

    EmployeEntity findByEmail(String email);
}
