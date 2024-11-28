package com.example.pupsp.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pupsp.entities.Houses;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.HousesRepository;
import com.example.pupsp.repository.UsersRepository;
import com.example.pupsp.service.HousesService;


@Controller
public class HousesController {

    @Autowired
    private HousesRepository housesService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private HousesService housesService2;

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

    @GetMapping("/editAddresses")
    public String editAddresses(@RequestParam("id") int id, Model model) {
        try {
            Optional<Houses> house = housesService.findById(id);
            Houses houseObj = house.get();

            String fullAddress = houseObj.getAdress(); // Asumimos que 'direccion' es el campo que tiene la dirección completa.

            // Dividir la dirección en partes
            String[] addressParts = fullAddress.split(", ");
            String barrio = addressParts[0]; // Barrio
            String tipoCalle = addressParts[1].split(" ")[0]; // Tipo de calle (Ej: "Avenida")
            String calle = addressParts[1].split(" ")[1]; // Calle (Ej: "12" de "Avenida 12")
            String[] numeroCalle = addressParts[1].split(" ")[2].split("-"); // Número (Ej: "12-34")

            
            model.addAttribute("Houses", houseObj);
            model.addAttribute("barrio", barrio);
            model.addAttribute("tipoCalle", tipoCalle);
            model.addAttribute("calle", calle);
            model.addAttribute("numeroCalle1", numeroCalle[0]);
            model.addAttribute("numeroCalle2", numeroCalle[1]);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "build/edit-address";
    }

    @GetMapping("/deleteAddresses/{id}")
    public String deleteAddresses(@PathVariable int id) {
        try {
            housesService2.deleteHouseAndDependencies(id);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "redirect:/casas";
    }
}
