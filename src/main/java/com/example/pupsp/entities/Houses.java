package com.example.pupsp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Houses {

    @Id
    private int id;
    private String adress;
    private String municipio;
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "users_id", nullable = false)
    private Users user;

    public Houses() {
    }

    public Houses(int id, String adress, String municipio, int tipo, Users user) {
        this.id = id;
        this.adress = adress;
        this.municipio = municipio;
        this.tipo = tipo;
        this.user = user;
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    
}
