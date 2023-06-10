package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.request.BuildingSearchRequest;
import com.laptrinhjavaweb.response.BuildingSearchRespone;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    List<BuildingSearchRespone> findAll(BuildingSearchRequest buildingSearchRequest);
    void save(BuildingDTO buildingDTO);
    Map<String,String> getDistrictCode();
    Map<String,String> getType();
    void deleteBuilding(Long[] ids);
    String getRentArea(Long id);
    BuildingDTO findBuildingById(Long id);
    void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest);
}
