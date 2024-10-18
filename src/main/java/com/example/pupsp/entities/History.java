package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class History {

    @Id
    private int id;
    private String paymentDate;
    private String paymentmethod;
    private int bills_id;
    public History() {
    }
    public History(int id, String paymentDate, String paymentmethod, int bills_id) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentmethod = paymentmethod;
        this.bills_id = bills_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
    public String getPaymentmethod() {
        return paymentmethod;
    }
    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }
    public int getBills_id() {
        return bills_id;
    }
    public void setBills_id(int bills_id) {
        this.bills_id = bills_id;
    }
    
}
