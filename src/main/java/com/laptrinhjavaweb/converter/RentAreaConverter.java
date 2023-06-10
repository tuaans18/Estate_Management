package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentAreaConverter {

    @Autowired
    private ModelMapper modelMapper;

    public RentAreaDTO convertRentAreaEntityToDto(RentAreaEntity rentAreaEntity){
        RentAreaDTO rentAreaDTO = modelMapper.map(rentAreaEntity,RentAreaDTO.class);
        return rentAreaDTO;
    }

    public RentAreaEntity covertRentAreaDtoToEntity(RentAreaDTO rentAreaDTO){
        RentAreaEntity rentAreaEntity = modelMapper.map(rentAreaDTO,RentAreaEntity.class);
        return rentAreaEntity;
    }
}
