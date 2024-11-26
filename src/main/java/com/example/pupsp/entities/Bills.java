package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bills {

    @Id
    private int id;
    private int cost;
    private String issueDate;
    private String expirationDate;
    private int payDone;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "companyUtilities_id", nullable = false)
    private CompanyUtilities companyUtility;

    @ManyToOne
    @JoinColumn(name = "houses_id", nullable = false)
    private Houses house;

    public Bills() {
    }

    public Bills(int id, int cost, String issueDate, String expirationDate, int payDone, Users user,
            CompanyUtilities companyUtility, Houses house) {
        this.id = id;
        this.cost = cost;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.payDone = payDone;
        this.user = user;
        this.companyUtility = companyUtility;
        this.house = house;
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public CompanyUtilities getCompanyUtility() {
        return companyUtility;
    }

    public void setCompanyUtility(CompanyUtilities companyUtility) {
        this.companyUtility = companyUtility;
    }

    public Houses getHouse() {
        return house;
    }

    public void setHouse(Houses house) {
        this.house = house;
    }

    

}
