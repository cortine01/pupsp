package com.example.pupsp.controller;

import java.util.List;
import java.util.Optional;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.UsersRepository;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {

        try {
            List<Users> listUsers = usersRepository.findAll();
            model.addAttribute("Users", listUsers);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "admin/users/index";
    }

    @GetMapping("/addUsers")
    public String addUsers() {
        return "admin/users/add";
    }

    @PostMapping("/saveUsers")
    public String saveUsers(@Validated Users users) {

        if (users.getRegisterDate() == null) {

            // Obtener la fecha actual como LocalDate
            LocalDate currentDate = LocalDate.now();
            
            // Formatear la fecha como String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            users.setRegisterDate(formattedDate); // Establecer fecha actual si es nulo
        }

        usersRepository.save(users);
        return "redirect:/perfil";
    }

    @GetMapping("/admin/editUsers/{id}")
    public String adminEditUsers(@PathVariable int id, Model model) {
        try {
            Optional<Users> user = usersRepository.findById(id);
            model.addAttribute("Users", user.get());
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return "admin/users/edit";
    }

    @GetMapping("/deleteUsers/{id}")
    public String deleteUsers(@PathVariable int id) {
        try {
            usersRepository.deleteById(id);
            System.out.println(id);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "redirect:/listUsers";
    }

    @GetMapping("/perfil")
    public String perfil(Model model, Principal principal) {
        try {
            String email = principal.getName();
            Users user = usersRepository.findByEmail(email);

            model.addAttribute("User", user);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return("build/myprofile");
    }

    @GetMapping("/editUsers")
    public String EditUsers(Model model, Principal principal) {
        try {
            String email = principal.getName();

            Users user = usersRepository.findByEmail(email);

            model.addAttribute("Users", user);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return "build/edit-data";
    }
}
