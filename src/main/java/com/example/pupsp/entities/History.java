package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class History {

    @Id
    private int id;
    private String paymentDate;
    private String paymentmethod;

    @OneToOne
    @JoinColumn(name = "bills_id", nullable = true)
    private Bills bills;

    public History() {
    }

    public History(int id, String paymentDate, String paymentmethod, Bills bills) {
        this.id = id;
        this.paymentDate = paymentDate;
        this.paymentmethod = paymentmethod;
        this.bills = bills;
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

    public Bills getBills() {
        return bills;
    }

    public void setBills(Bills bills) {
        this.bills = bills;
    }

}
