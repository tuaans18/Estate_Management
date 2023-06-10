package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long>, CustomerRepositoryCustom {
    void deleteByIdIn(Long[] ids);
}
