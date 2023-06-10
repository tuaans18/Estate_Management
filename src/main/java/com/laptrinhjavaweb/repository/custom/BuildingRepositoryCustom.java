package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;

import java.util.List;

public interface BuildingRepositoryCustom{
    List<BuildingEntity> findBuildingByCondition(BuildingSearchBuilder buildingSearchBuilder);
}
