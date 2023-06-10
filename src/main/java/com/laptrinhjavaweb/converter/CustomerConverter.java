package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.CustomerEntity;
import com.laptrinhjavaweb.request.CustomerSearchRequest;
import com.laptrinhjavaweb.response.CustomerSearchRespone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CustomerConverter  {
    @Autowired
    private ModelMapper modelMapper;

    public CustomerSearchBuilder convertToCustomerSearchBuilder(CustomerSearchRequest customerSearchRequest){
        CustomerSearchBuilder result = new CustomerSearchBuilder.CustomerBuilder()
                .setFullName(customerSearchRequest.getFullName())
                .setEmail(customerSearchRequest.getEmail())
                .setPhone(customerSearchRequest.getPhone())
                .setStaffId(customerSearchRequest.getStaffId())
                .build();
        return result;
    }

    public CustomerSearchRespone convertEntityToBuildingSearchRespone (CustomerEntity entity){
        CustomerSearchRespone result = modelMapper.map(entity, CustomerSearchRespone.class);
        return result;
    }

    public CustomerDTO convertEntityToBuildingDTO(CustomerEntity entity){
        CustomerDTO result = modelMapper.map(entity,CustomerDTO.class);
        return result;
    }

    public CustomerEntity convertDtoToBuildingEntity(CustomerDTO customerDTO){
        CustomerEntity result = modelMapper.map(customerDTO,CustomerEntity.class);
        return result;
    }
}
