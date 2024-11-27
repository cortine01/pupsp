package com.example.pupsp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.Houses;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.HousesRepository;
import com.example.pupsp.repository.UsersRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HousesController {

    @Autowired
    private HousesRepository housesService;

    @Autowired
    private UsersRepository usersRepository;

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

    @GetMapping("/casas")
    public String buildHouses(Model model, Principal principal) {
        try {

            String email = principal.getName();
            Users user = usersRepository.findByEmail(email);

            List<Houses> listHouses = housesService.findByUser(user);
            model.addAttribute("Houses", listHouses);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "build/addresses";
    }

    @GetMapping("/addAddresses")
    public String addAddresses() {
        return "build/add-address";
    }
    
    @PostMapping("/saveAddresses")
    public String saveAddresses(@Validated Houses houses, Principal principal) {
        String email = principal.getName();
        Users user = usersRepository.findByEmail(email);
        houses.setUser(user);
        housesService.save(houses);
        return "redirect:/casas";
    }
}
