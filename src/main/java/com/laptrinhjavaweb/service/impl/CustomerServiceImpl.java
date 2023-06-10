package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.converter.CustomerConverter;
import com.laptrinhjavaweb.converter.TransactionConverter;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.enums.TransactionTypeEnum;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.repository.TransactionRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.entity.TransactionEntity;
import com.laptrinhjavaweb.repository.entity.UserEntity;
import com.laptrinhjavaweb.request.AssignmentCustomerRequest;
import com.laptrinhjavaweb.request.CustomerSearchRequest;
import com.laptrinhjavaweb.response.CustomerSearchRespone;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private TransactionConverter transactionConverter;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<CustomerSearchRespone> findAll(CustomerSearchRequest customerSearchRequest) {
        List<CustomerSearchRespone> results = new ArrayList<>();
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            customerSearchRequest.setStaffId(staffId);
        }
        CustomerSearchBuilder customerSearchBuilder = customerConverter.convertToCustomerSearchBuilder(customerSearchRequest);
        if(!checkValue(customerSearchRequest)) {
            results = customerRepository.findAll().stream()
                    .map(customerConverter::convertEntityToBuildingSearchRespone)
                    .collect(Collectors.toList());
        }
        else {
            results = customerRepository.finCustomerByCondition(customerSearchBuilder).stream()
                    .map(customerConverter::convertEntityToBuildingSearchRespone)
                    .collect(Collectors.toList());
        }
        return results;
    }


    private boolean checkValue(CustomerSearchRequest customerSearchRequest) {
        Boolean check = false;
        try {
            Field[] fields = CustomerSearchRequest.class.getDeclaredFields();
            for(Field field :fields){
                field.setAccessible(true);
                Object objectValue = field.get(customerSearchRequest);
                if(objectValue !=null){
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
    public void save(CustomerDTO customerDTO) {
        List<UserEntity> staffs = new ArrayList<>();
        if(customerDTO.getId()!=null){
            staffs =  customerRepository.findOne(customerDTO.getId()).getStaffs();
        }
        CustomerEntity customerEntity = customerConverter.convertDtoToBuildingEntity(customerDTO);
        customerEntity.setStaffs(staffs);
        customerRepository.save(customerEntity);
    }

    @Override
    public Map<String, String> getTransactionCode() {
        Map<String,String> transactions = new HashMap<>();
        for(TransactionTypeEnum item: TransactionTypeEnum.values()){
            transactions.put(item.toString(),item.getTrannsactionTypeValue());
        }
        return transactions;
    }

    @Override
    public List<TransactionDTO> getTransaction(Long idCustomer) {
        CustomerEntity customerEntity = customerRepository.findOne(idCustomer);
        List<TransactionEntity> transactionEntities = customerEntity.getTransactions();
        List<TransactionDTO> transactionDTOS = transactionEntities.stream()
                .map(transactionConverter::convertEntityToTransactionDTO)
                .collect(Collectors.toList());
        return transactionDTOS;
    }

    @Override
    public void saveTransaction(TransactionDTO transactionDTO) {
        TransactionEntity transactionEntity = transactionConverter.convertToTransactionEntity(transactionDTO);
        transactionRepository.save(transactionEntity);
    }

    @Override
    @Transactional
    public void deleteCustomer(Long[] ids) {
        customerRepository.deleteByIdIn(ids);
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        CustomerDTO customerDTO = customerConverter.convertEntityToBuildingDTO(customerRepository.findOne(id));
        return customerDTO;
    }

    @Override
    public void assignmentCustomer(AssignmentCustomerRequest assignmentCustomerRequest) {
        List<Long> listStaffId = assignmentCustomerRequest.getListStaffId();
        Long customerId = assignmentCustomerRequest.getCustomerId();
        List<UserEntity> listStaff = userRepository.findAllByIdIn(listStaffId);
        CustomerEntity customerEntity = customerRepository.findOne(customerId);
        customerEntity.setStaffs(listStaff);
        customerRepository.save(customerEntity);
    }
}
