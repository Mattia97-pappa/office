package com.example.ufficio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ufficio.entity.Employees;
import com.example.ufficio.entity.Offices;
import com.example.ufficio.repository.OfficesRepository;

@Controller
@RequestMapping("/offices")
public class OfficesController {
    
@Autowired
private OfficesRepository officesrepository;



@GetMapping("/all")
    public String listOffices(Model model) {
    List<Offices> offices = officesrepository.findAll();
    model.addAttribute("offices", offices);
    return "offices";
    }

       @GetMapping("/delete/{id}")
public String deleteOffices(@PathVariable("id") int id) {
if(officesrepository.existsById(id))
officesrepository.deleteById(id);
return "redirect:/offices/all";
}

@GetMapping("/edit/{id}")
public String showEditOffices(@PathVariable("id") int id, Model model) {
Offices offices = officesrepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("offices", offices);
return "editOffices";
}

@PostMapping("/upd")
public String updateOffices(@ModelAttribute("offices") Offices offices) {
officesrepository.save(offices);
return "redirect:/offices/all";
}

@GetMapping("/new")
    public String showNewOffices(Model model) {
    model.addAttribute("offices", new Offices());
    return "newOffices";
    }
@PostMapping(path="/add") // Map ONLY POST Requests
  public String addNewEmployees (@RequestParam String city,@RequestParam String phone,@RequestParam String addressLine1,@RequestParam String addressLine2,@RequestParam String state,@RequestParam String country,@RequestParam String postalCode,@RequestParam String territory) {
 

    Offices n = new Offices();
    n.setCity(city);
    n.setPhone(phone);
    n.setAddressLine1(addressLine1);
    n.setAddressLine2(addressLine2);
    n.setState(state);
    n.setCountry(country);
    n.setPostalCode(postalCode);
    n.setTerritory(territory);


  
    





    officesrepository.save(n);
    return "redirect:/offices/all";
  }
}




