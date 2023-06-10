package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import com.laptrinhjavaweb.request.BuildingSearchRequest;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.response.BuildingSearchRespone;
import com.laptrinhjavaweb.utils.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;


    public BuildingSearchRespone convertEntityToBuildingSearchRespone (BuildingEntity entity){
        BuildingSearchRespone result = modelMapper.map(entity, BuildingSearchRespone.class);
        String district = entity.getDistrict();
        if(!district.equals("-1")) {
            result.setAddress(entity.getStreet() + ", " + entity.getWard() + ", " + DistrictsEnum.valueOf(district).getDistrictValue());
        }
        return result;
    }

    public BuildingDTO convertEntityToBuildingDTO(BuildingEntity entity){
        BuildingDTO result = modelMapper.map(entity,BuildingDTO.class);
        List<String> types = Arrays.asList(entity.getType().split(","));
        result.setTypes(types);
        return result;
    }

    public BuildingEntity convertDtoToBuildingEntity(BuildingDTO buildingDTO){
        BuildingEntity result = modelMapper.map(buildingDTO,BuildingEntity.class);
        List<RentAreaEntity> rentAreaEntities = covertStringToRentAreaEntity(buildingDTO.getRentArea(),result);
        result.setRentAreas(rentAreaEntities);
        result.setType(String.join(",",buildingDTO.getTypes()));
        return result;
    }

    private List<RentAreaEntity> covertStringToRentAreaEntity(String rentArea, BuildingEntity result) {
        List<RentAreaEntity> results = new ArrayList<>();
        if(!StringUtils.isNullOrEmpty(rentArea)){
            String[] arrRentArea = rentArea.split(",");
            for(String aString : arrRentArea){
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(Integer.valueOf(aString));
                rentAreaEntity.setBuildings(result);
                results.add(rentAreaEntity);
            }
        }
        return results;
    }


    public BuildingSearchBuilder convertToBuildingSearchBuilder(BuildingSearchRequest buildingSearchRequest){
        BuildingSearchBuilder result = new BuildingSearchBuilder.BuildingBuilder()
                                        .setAreaFrom(buildingSearchRequest.getAreaFrom())
                                        .setAreaTo(buildingSearchRequest.getAreaTo())
                                        .setDirection(buildingSearchRequest.getDirection())
                                        .setDistrict(buildingSearchRequest.getDistrict())
                                        .setFloorArea(buildingSearchRequest.getFloorArea())
                                        .setLevel(buildingSearchRequest.getLevel())
                                        .setManagerName(buildingSearchRequest.getManagerName())
                                        .setManagerPhone(buildingSearchRequest.getManagerPhone())
                                        .setName(buildingSearchRequest.getName())
                                        .setNumberOfBasement(buildingSearchRequest.getNumberOfBasement())
                                        .setRentPriceFrom(buildingSearchRequest.getRentPriceFrom())
                                        .setRentPriceTo(buildingSearchRequest.getRentPriceTo())
                                        .setStaffId(buildingSearchRequest.getStaffId())
                                        .setStreet(buildingSearchRequest.getStreet())
                                        .setTypes(buildingSearchRequest.getTypes())
                                        .setWard(buildingSearchRequest.getWard())
                                        .build();
        return result;
    }
}
