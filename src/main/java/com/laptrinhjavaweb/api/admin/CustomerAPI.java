package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.request.AssignmentCustomerRequest;
import com.laptrinhjavaweb.response.ResponeDTO;
import com.laptrinhjavaweb.response.StaffResponseDTO;
import com.laptrinhjavaweb.service.CustomerService;
import com.laptrinhjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
public class CustomerAPI {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;


    @PostMapping
    public CustomerDTO createCustomer(@RequestBody CustomerDTO newCustomer){
        customerService.save(newCustomer);
        return newCustomer;
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable("id") long id, @RequestBody CustomerDTO customerDTO) {
        customerService.save(customerDTO);
        return customerDTO;
    }
    @GetMapping("/{id}/staffs")
    public ResponeDTO loadStaff(@PathVariable("id") Long customerId) {
        ResponeDTO result = new ResponeDTO();
        List<StaffResponseDTO> staffs  = userService.getStaffByCustomer(customerId);
        result.setMessage("success");
        result.setData(staffs);
        return result;
    }

    @DeleteMapping
    public ResponeDTO deleteCustomer(@RequestBody Long[] idList){
        ResponeDTO result = new ResponeDTO();
        if(idList.length > 0){
            customerService.deleteCustomer(idList);
            result.setMessage("success");
            return result;
        }
        return null;
    }

    @PostMapping("/transaction")
    public ResponeDTO createTransaction(@RequestBody TransactionDTO transactionDTO){
        ResponeDTO result = new ResponeDTO();
        if(!transactionDTO.getNote().isEmpty()){
            customerService.saveTransaction(transactionDTO);
            result.setMessage("success");
            return result;
        }
        return null;
    }

    @PostMapping("/assignment")
    public ResponeDTO assignmentCustomer(@RequestBody AssignmentCustomerRequest assignmentCustomerRequest){
        ResponeDTO result = new ResponeDTO();
        customerService.assignmentCustomer(assignmentCustomerRequest);
        result.setMessage("success");
        return result;
    }

}
