package com.example.pupsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.CompanyUtilities;
import com.example.pupsp.repository.CompanyUtilitiesRepository;


@Controller
public class CompanyUtilitiesController {

    @Autowired
    private CompanyUtilitiesRepository companyUtilitiesService;

    @GetMapping("/listCompanyUtilities")
    public String listCompanyUtilities(Model model) {
        try {
            List<CompanyUtilities> listCompanyUtilities = companyUtilitiesService.findAll();
            model.addAttribute("CompanyUtilities", listCompanyUtilities);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return "admin/companyUtilities/index";
    }
}
