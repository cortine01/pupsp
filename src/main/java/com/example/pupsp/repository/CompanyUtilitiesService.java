package com.example.pupsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.CompanyUtilities;

@Repository
public interface CompanyUtilitiesService extends JpaRepository<CompanyUtilities, Integer>{

}