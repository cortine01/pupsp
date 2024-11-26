package com.example.pupsp.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.History;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.BillsRepository;
import com.example.pupsp.repository.HistoryRepository;
import com.example.pupsp.repository.UsersRepository;

@Controller
public class HistoryController {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private BillsRepository billsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/historial")
    public String listHistory(Model model, Principal principal) {

        try {
            // Obtén el email del usuario logueado
            String email = principal.getName();

            // Busca el usuario por su email
            Users user = usersRepository.findByEmail(email);

            List<Bills> listBills = billsRepository.findByUser(user);

            List<History> listHistory = listBills.stream()
            .map(historyRepository::findByBills) // Obtiene historiales por cada recibo
            .flatMap(List::stream) // Aplana la lista (para evitar listas anidadas)
            .toList(); // Convierte el stream a una lista
            model.addAttribute("History", listHistory);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return "build/historial";
    }
}
