package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Houses {

    @Id
    private int id;
    private String adress;
    private int users_id;
    public Houses() {
    }
    public Houses(int id, String adress, int users_id) {
        this.id = id;
        this.adress = adress;
        this.users_id = users_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public int getUsers_id() {
        return users_id;
    }
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }
    
}
