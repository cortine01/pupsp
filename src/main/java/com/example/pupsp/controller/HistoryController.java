package com.example.pupsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.History;
import com.example.pupsp.repository.HistoryService;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/listHistory")
    public String listHistory(Model model) {
        try {
            List<History> listHistory = historyService.findAll();
            model.addAttribute("History", listHistory);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return "admin/history/index";
    }
}
