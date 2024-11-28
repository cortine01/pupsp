package com.example.pupsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.CompanyUtilities;
import com.example.pupsp.entities.Houses;
import com.example.pupsp.entities.Users;

@Repository
public interface BillsRepository extends JpaRepository<Bills, Integer>{
    List<Bills> findByUser(Users user);
    List<Bills> findByCompanyUtility(CompanyUtilities companyUtility);
    List<Bills> findByHouse(Houses house);
    List<Bills> findByPayDone(int payDone);
    List<Bills> findByUserAndPayDone(Users user, int payDone);
    List<Bills> findByHouseId(int houseId);
    void deleteByHouseId(int houseId);
}
