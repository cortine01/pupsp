package com.example.pupsp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Notifications;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.NotiRepository;
import com.example.pupsp.repository.UsersRepository;

@Controller
public class NotiController {

    @Autowired
    private NotiRepository notiService;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/notificacion")
    public String listNoti(Model model, Principal principal) {
        try {
            String email = principal.getName();

            Users user = usersRepository.findByEmail(email);

            List<Notifications> listNoti = notiService.findByUser(user);
            model.addAttribute("Notifications", listNoti);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "build/notifications";
    }
}
