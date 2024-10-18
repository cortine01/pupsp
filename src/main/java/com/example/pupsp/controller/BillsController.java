package com.example.pupsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.services.BillsService;

@Controller
public class BillsController {

    @Autowired
    private BillsService billsService;

    @GetMapping("/listBills")
    public String listBills(Model model) {
        try {
            List<Bills> listBills = billsService.findAll();
            model.addAttribute("Bills", listBills);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return "admin/bills/index";
    }
}
