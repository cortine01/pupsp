package com.example.pupsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Houses;
import com.example.pupsp.repository.HousesRepository;

@Controller
public class HousesController {

    @Autowired
    private HousesRepository housesService;

    @GetMapping("/listHouses")
    public String listHouses(Model model) {
        try {
            List<Houses> listHouses = housesService.findAll();
            model.addAttribute("Houses", listHouses);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "admin/houses/index";
    }
}
