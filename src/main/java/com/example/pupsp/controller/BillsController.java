package com.example.pupsp.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pupsp.entities.Bills;
import com.example.pupsp.entities.CompanyUtilities;
import com.example.pupsp.entities.Houses;
import com.example.pupsp.entities.Users;
import com.example.pupsp.repository.BillsRepository;
import com.example.pupsp.repository.CompanyUtilitiesRepository;
import com.example.pupsp.repository.HousesRepository;
import com.example.pupsp.repository.UsersRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class BillsController {

    @Autowired
    private BillsRepository billsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CompanyUtilitiesRepository companyUtilitiesRepository;

    @Autowired
    private HousesRepository housesRepository;

    @GetMapping("/recibos")
    public String listBillsUser(Model model, Principal principal) {
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

    @GetMapping("/admin/listBills")
    public String listBills(Model model) {
        try {
            List<Bills> listBills = billsRepository.findAll();
            model.addAttribute("Bills", listBills);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "admin/bills/index";
    }
    
    @GetMapping("/admin/addBill")
    public String addBill(Model model) {
        
        try {
            List<Users> listUsers = usersRepository.findAll();
            model.addAttribute("Users", listUsers);

            List<CompanyUtilities> listCompanyUtilities = companyUtilitiesRepository.findAll();
            model.addAttribute("CompanyUtilities", listCompanyUtilities);

            List<Houses> listHouses = housesRepository.findAll();
            model.addAttribute("Houses", listHouses);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }

        return "admin/bills/add";
    }

    @PostMapping("/admin/saveBill")
    public String saveBill(@Validated Bills bills) {

        if (bills.getIssueDate() == null) {

            // Obtener la fecha actual como LocalDate
            LocalDate currentDate = LocalDate.now();
            
            // Formatear la fecha como String
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = currentDate.format(formatter);

            bills.setIssueDate(formattedDate); // Establecer fecha actual si es nulo
            
            LocalDate expirationDate = currentDate.plusDays(28);
            String formattedExpirationDate = expirationDate.format(formatter);

            // Establecer la fecha de expiración
            bills.setExpirationDate(formattedExpirationDate);
        }

        billsRepository.save(bills);
        return "redirect:/recibos";
    }

    @GetMapping("/getHousesByUser")
    @ResponseBody
    public List<Houses> getHousesByUser(@RequestParam("userId") int userId) {
        try {
            Users user = usersRepository.findById(userId).orElse(null);
            if (user != null) {
                return housesRepository.findByUser(user);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return List.of(); // Devuelve una lista vacía si no se encuentra el usuario o hay un error
    }
}
