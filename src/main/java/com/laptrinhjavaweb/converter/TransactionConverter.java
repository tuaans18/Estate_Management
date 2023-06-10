package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;

    public TransactionDTO convertEntityToTransactionDTO(TransactionEntity entity){
        TransactionDTO result = modelMapper.map(entity,TransactionDTO.class);
        return result;
    }

    public TransactionEntity convertToTransactionEntity(TransactionDTO transactionDTO){
        TransactionEntity transactionEntity = modelMapper.map(transactionDTO,TransactionEntity.class);
        transactionEntity.setCustomers(customerRepository.findOne(transactionDTO.getCustomerId()));
        return transactionEntity;
    }
}
