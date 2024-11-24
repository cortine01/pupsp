package com.example.pupsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
    public Users findByEmail(String email);
}
