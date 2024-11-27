package com.example.pupsp.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pupsp.entities.Notifications;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.NotiRepository;

@Service
public class NotiService {

    @Autowired
    private NotiRepository notiRepository;

    public void createNotification(String message, int type, Users user) {
        // Formatear la fecha actual como String
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        // Crear la notificación
        Notifications notification = new Notifications();
        notification.setMassage(message);
        notification.setChipingDate(formattedDate);
        notification.setType(type);
        notification.setUser(user);

        // Guardar en la base de datos
        notiRepository.save(notification);
    }
}
