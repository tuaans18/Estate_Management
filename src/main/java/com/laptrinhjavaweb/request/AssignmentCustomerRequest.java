package com.laptrinhjavaweb.request;

import java.util.List;

public class AssignmentCustomerRequest {

    private List<Long> listStaffId;
    private Long customerId;


    public List<Long> getListStaffId() {
        return listStaffId;
    }

    public void setListStaffId(List<Long> listStaffId) {
        this.listStaffId = listStaffId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
