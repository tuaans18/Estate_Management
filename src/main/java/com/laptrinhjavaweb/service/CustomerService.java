package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.request.AssignmentBuildingRequest;
import com.laptrinhjavaweb.request.AssignmentCustomerRequest;
import com.laptrinhjavaweb.request.CustomerSearchRequest;
import com.laptrinhjavaweb.response.CustomerSearchRespone;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<CustomerSearchRespone> findAll(CustomerSearchRequest customerSearchRequest);
    void save(CustomerDTO customerDTO);
    void deleteCustomer(Long[] ids);
    CustomerDTO findCustomerById(Long id);
    Map<String,String> getTransactionCode();
    List<TransactionDTO> getTransaction(Long idCustomer);
    void saveTransaction(TransactionDTO transactionDTO);
    void assignmentCustomer(AssignmentCustomerRequest assignmentCustomerRequest);
}
