package com.example.pupsp.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.History;

@Repository
public interface HistoryService extends JpaRepository<History, Integer>{

}
