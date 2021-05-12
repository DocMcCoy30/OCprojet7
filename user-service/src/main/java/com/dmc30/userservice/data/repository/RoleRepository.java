package com.dmc30.userservice.data.repository;

import com.dmc30.userservice.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <RoleEntity, Long> {
}
