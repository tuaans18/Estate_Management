package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.repository.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom{
    List<UserEntity> findStaffByBuilding(Long buildingId);
    List<UserEntity> findStaffByCustomer(Long customerId);
}
