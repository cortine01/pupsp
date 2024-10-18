package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Notifications {

    @Id
    private int id;
    private String massage;
    private String chipingDate;
    private int users_id;
    public Notifications() {
    }
    public Notifications(int id, String massage, String chipingDate, int users_id) {
        this.id = id;
        this.massage = massage;
        this.chipingDate = chipingDate;
        this.users_id = users_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMassage() {
        return massage;
    }
    public void setMassage(String massage) {
        this.massage = massage;
    }
    public String getChipingDate() {
        return chipingDate;
    }
    public void setChipingDate(String chipingDate) {
        this.chipingDate = chipingDate;
    }
    public int getUsers_id() {
        return users_id;
    }
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
    
}
