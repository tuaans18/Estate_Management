package com.laptrinhjavaweb.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity{

    @Column(name="code")
    private String code;

    @Column(name="note")
    private String note;


    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "customerid")
    private CustomerEntity customers;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public CustomerEntity getCustomers() {
        return customers;
    }

    public void setCustomers(CustomerEntity customers) {
        this.customers = customers;
    }
}
