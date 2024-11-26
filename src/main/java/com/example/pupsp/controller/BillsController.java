package com.example.pupsp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.BillsRepository;
import com.example.pupsp.repository.UsersRepository;

@Controller
public class BillsController {

    @Autowired
    private BillsRepository billsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/bills")
    public String listBills(Model model, Principal principal) {
        try {
            // Obtén el email del usuario logueado
            String email = principal.getName();

            // Busca el usuario por su email
            Users user = usersRepository.findByEmail(email);

            List<Bills> listBills = billsRepository.findByUser(user);


            System.out.println("LLegue");

            model.addAttribute("Bills", listBills);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return "build/recibos";
    }
}
