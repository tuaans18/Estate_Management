package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.repository.entity.RoleEntity;
import com.laptrinhjavaweb.repository.custom.RoleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>, RoleRepositoryCustom {
	RoleEntity findOneByCode(String code);
}
