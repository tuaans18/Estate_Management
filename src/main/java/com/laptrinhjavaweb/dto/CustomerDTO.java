package com.laptrinhjavaweb.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomerDTO {
    private Long id;
    private String fullName;
    private String phone;
    private String email;
    private Long staffId;
    private Date createdDate;
    private Date modifiedDate;
    private Map<String,String> transactionMaps = new HashMap<>();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Map<String, String> getTransactionMaps() {
        return transactionMaps;
    }

    public void setTransactionMaps(Map<String, String> districtMaps) {
        this.transactionMaps = districtMaps;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
