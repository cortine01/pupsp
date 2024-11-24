package com.example.pupsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Notifications;
import com.example.pupsp.repository.NotiService;

@Controller
public class NotiController {

    @Autowired
    private NotiService notiService;

    @GetMapping("/listNotification")
    public String listNoti(Model model) {
        try {
            List<Notifications> listNoti = notiService.findAll();
            model.addAttribute("Notifications", listNoti);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "admin/noti/index";
    }
}
