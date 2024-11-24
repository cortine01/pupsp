package com.example.pupsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Houses;

@Repository
public interface HousesService extends JpaRepository<Houses, Integer>{

}
