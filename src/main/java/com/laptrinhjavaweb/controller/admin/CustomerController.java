package com.laptrinhjavaweb.controller.admin;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.CustomerDTO;
import com.laptrinhjavaweb.dto.TransactionDTO;
import com.laptrinhjavaweb.request.CustomerSearchRequest;
import com.laptrinhjavaweb.service.CustomerService;
import com.laptrinhjavaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller(value = "customerControllerOfAdmin")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/admin/customer-list", method = RequestMethod.GET)
    public ModelAndView customerList(@ModelAttribute("modelSearch") CustomerSearchRequest customerSearchRequest
                                     ) {
        ModelAndView mav = new ModelAndView("admin/customer/list");
        mav.addObject("modelSearch",customerSearchRequest);
        mav.addObject("customers", customerService.findAll(customerSearchRequest));
        mav.addObject("staffmaps",userService.getStaffMaps());
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit-{id}", method = RequestMethod.GET)
    public ModelAndView customerEdit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        CustomerDTO model = customerService.findCustomerById(id);
        model.setTransactionMaps(customerService.getTransactionCode());
        List<TransactionDTO> transactionDTOS = customerService.getTransaction(id);
        mav.addObject(SystemConstant.MODEL,model);
        mav.addObject("transaction",transactionDTOS);
        return mav;
    }

    @RequestMapping(value = "/admin/customer-edit", method = RequestMethod.GET)
    public ModelAndView customerAdd(@ModelAttribute(SystemConstant.MODEL) CustomerDTO model) {
        ModelAndView mav = new ModelAndView("admin/customer/edit");
        model.setTransactionMaps(customerService.getTransactionCode());
        mav.addObject(SystemConstant.MODEL,model);
        return mav;
    }

}