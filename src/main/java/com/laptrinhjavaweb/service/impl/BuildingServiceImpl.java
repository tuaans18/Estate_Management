package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.UserEntity;
import com.laptrinhjavaweb.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.request.BuildingSearchRequest;
import com.laptrinhjavaweb.response.BuildingSearchRespone;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private RentAreaConverter rentAreaConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<BuildingSearchRespone> findAll(BuildingSearchRequest buildingSearchRequest) {
        List<BuildingSearchRespone> results = new ArrayList<>();
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffId(staffId);
        }
        BuildingSearchBuilder buildingSearchBuilder = buildingConverter.convertToBuildingSearchBuilder(buildingSearchRequest);
        if(!checkValue(buildingSearchRequest) && CollectionUtils.isEmpty(buildingSearchBuilder.getTypes())) {
            results = buildingRepository.findAll().stream()
                    .map(buildingConverter::convertEntityToBuildingSearchRespone)
                    .collect(Collectors.toList());
        }
        else {
            results = buildingRepository.findBuildingByCondition(buildingSearchBuilder).stream()
                    .map(buildingConverter::convertEntityToBuildingSearchRespone)
                    .collect(Collectors.toList());
        }
        return results;
    }

    private boolean checkValue(BuildingSearchRequest buildingSearchRequest) {
        Boolean check = false;
        try {
            Field[] fields = BuildingSearchRequest.class.getDeclaredFields();
            for(Field field :fields){
                field.setAccessible(true);
                Object objectValue = field.get(buildingSearchRequest);
                if(objectValue !=null && !field.getName().equals("types")){
                    if(!objectValue.toString().equals("-1") && !objectValue.toString().isEmpty() ){
                        check = true;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }


    @Override
    @Transactional
    public void save(BuildingDTO buildingDTO) {
        List<UserEntity> staffs = new ArrayList<>();
        if(buildingDTO.getId()!=null) {
            staffs = buildingRepository.findOne(buildingDTO.getId()).getStaffs();
        }
        BuildingEntity buildingEntity = buildingConverter.convertDtoToBuildingEntity(buildingDTO);
        buildingEntity.setStaffs(staffs);
        buildingRepository.save(buildingEntity);
    }

    @Override
    public Map<String, String> getDistrictCode() {
        Map<String,String> districts = new HashMap<>();
        for(DistrictsEnum item: DistrictsEnum.values()){
            districts.put(item.toString(),item.getDistrictValue());
        }
        return districts;
    }

    @Override
    public Map<String, String> getType() {
        Map<String,String> buildingTypes = new HashMap<>();
        for(BuildingTypesEnum item: BuildingTypesEnum.values()){
            buildingTypes.put(item.toString(),item.getBuildingTypeValue());
        }
        return buildingTypes;
    }

    @Override
    @Transactional
    public void deleteBuilding(Long[] ids) {
        buildingRepository.deleteByIdIn(ids);
    }

    @Override
    public BuildingDTO findBuildingById(Long id) {
        BuildingDTO buildingDTO = buildingConverter.convertEntityToBuildingDTO(buildingRepository.findOne(id));
        return buildingDTO;
    }

    @Override
    public String getRentArea(Long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        if(!CollectionUtils.isEmpty(buildingEntity.getRentAreas())) {
            List<RentAreaDTO> results = buildingEntity.getRentAreas().stream().map(item -> rentAreaConverter.convertRentAreaEntityToDto(item)).collect(Collectors.toList());
            return covertListRentAreaToString(results);
        }
        return null;
    }

    private String covertListRentAreaToString(List<RentAreaDTO> list) {
        StringBuilder results = new StringBuilder("");
        for(int i = 0;i< list.size()-1;i++){
            results.append(list.get(i).getValue()+",");
        }
        results.append(list.get(list.size()-1).getValue());
        return results.toString();
    }


    @Override
    public void assignmentBuilding(AssignmentBuildingRequest assignmentBuildingRequest) {
        List<Long> listStaffId =assignmentBuildingRequest.getListStaffId();
        Long buildingId = assignmentBuildingRequest.getBuildingId();
        List<UserEntity> listStaff = userRepository.findAllByIdIn(listStaffId);
        BuildingEntity buildingEntity = buildingRepository.findOne(buildingId);
        buildingEntity.setStaffs(listStaff);
        buildingRepository.save(buildingEntity);
    }
}
