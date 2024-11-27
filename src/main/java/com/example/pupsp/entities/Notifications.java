package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Notifications {

    @Id
    private int id;
    private String massage;
    private String chipingDate;
    private int type;
    
    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users user;

    public Notifications() {
    }

    public Notifications(int id, String massage, String chipingDate, int type, Users user) {
        this.id = id;
        this.massage = massage;
        this.chipingDate = chipingDate;
        this.type = type;
        this.user = user;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
