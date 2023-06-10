package com.laptrinhjavaweb.repository.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{

    @Column(name ="fullname")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "assignmentcustomer",
            joinColumns = @JoinColumn(name = "customerid",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid",nullable = false))
    private List<UserEntity> staffs = new ArrayList<>();

    @OneToMany(mappedBy = "customers",cascade = {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval = true)
    private List<TransactionEntity> transactions = new ArrayList<>();

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

    public List<UserEntity> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<UserEntity> staffs) {
        this.staffs = staffs;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
