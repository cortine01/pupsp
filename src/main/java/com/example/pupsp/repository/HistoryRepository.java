package com.example.pupsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Integer>{
    List<History> findByBills(Bills bills);
    void deleteByBillsId(int billsId);
}
