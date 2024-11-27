package com.example.pupsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Houses;
import com.example.pupsp.entities.Users;

@Repository
public interface HousesRepository extends JpaRepository<Houses, Integer>{
    List<Houses> findByUser(Users user);
}
