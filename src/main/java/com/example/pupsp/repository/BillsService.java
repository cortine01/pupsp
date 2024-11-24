package com.example.pupsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Bills;

@Repository
public interface BillsService extends JpaRepository<Bills, Integer>{

}
