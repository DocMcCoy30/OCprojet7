package com.dmc30.userapi.data.repository;

import com.dmc30.userapi.data.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <RoleEntity, Long> {
}
