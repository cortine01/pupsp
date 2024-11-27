package com.example.pupsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Notifications;
import com.example.pupsp.entities.Users;

@Repository
public interface NotiRepository extends JpaRepository<Notifications, Integer>{
    List<Notifications> findByUser(Users user);
}
