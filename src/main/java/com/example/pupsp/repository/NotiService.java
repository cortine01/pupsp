package com.example.pupsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pupsp.entities.Notifications;

@Repository
public interface NotiService extends JpaRepository<Notifications, Integer>{

}
