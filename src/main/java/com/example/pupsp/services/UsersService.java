package com.example.pupsp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Users;

@Repository
public interface UsersService extends JpaRepository<Users, Integer>{

}
