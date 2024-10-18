package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bills {

    @Id
    private int id;
    private int cost;
    private String issueDate;
    private String expirationDate;
    private int payDone;
    private int users_id;
    private int companyUtilities_id;
    private int houses_id;
    public Bills() {
    }
    public Bills(int id, int cost, String issueDate, String expirationDate, int payDone, int users_id,
            int companyUtilities_id, int houses_id) {
        this.id = id;
        this.cost = cost;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.payDone = payDone;
        this.users_id = users_id;
        this.companyUtilities_id = companyUtilities_id;
        this.houses_id = houses_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    public int getPayDone() {
        return payDone;
    }
    public void setPayDone(int payDone) {
        this.payDone = payDone;
    }
    public int getUsers_id() {
        return users_id;
    }
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
    public int getCompanyUtilities_id() {
        return companyUtilities_id;
    }
    public void setCompanyUtilities_id(int companyUtilities_id) {
        this.companyUtilities_id = companyUtilities_id;
    }
    public int getHouses_id() {
        return houses_id;
    }
    public void setHouses_id(int houses_id) {
        this.houses_id = houses_id;
    }

}
