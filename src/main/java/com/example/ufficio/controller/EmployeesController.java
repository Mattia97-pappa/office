package com.example.ufficio.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ufficio.entity.AutoComplete;
import com.example.ufficio.entity.Employees;
import com.example.ufficio.repository.EmployeesRepository;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    

@Autowired
private EmployeesRepository employeesrepository;

  @GetMapping("/all")
    public String listEmployees(Model model) {
    List<Employees> employees = employeesrepository.findAll();
    model.addAttribute("employees", employees);
    return "employees";
    }

         @GetMapping("/delete/{id}")
public String deleteEmployee(@PathVariable("id") int id) {
if(employeesrepository.existsById(id))
employeesrepository.deleteById(id);
return "redirect:/employees/all";
}

@GetMapping("/edit/{id}")
public String showEditEmployee(@PathVariable("id") int id, Model model) {
Employees employees = employeesrepository.findById(id)
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
Employees boss = employeesrepository.findById(employees.getReportsTo())
.orElseThrow(() -> new IllegalArgumentException("Invalid User Id:" + id));
model.addAttribute("employees", employees);
model.addAttribute("bossName", boss.getLastName()+" "+boss.getFirstName());
return "editInfo";
}

@PostMapping("/upd")
public String updateEmployee(@ModelAttribute("employee") Employees employees) {
employeesrepository.save(employees);
return "redirect:/employees/all";
}

@GetMapping("/new")
    public String showNewEmployees(Model model) {
    model.addAttribute("employees", new Employees());
    return "newEmployees";
    }
@PostMapping(path="/add") // Map ONLY POST Requests
  public String addNewEmployees (@RequestParam String lastName, @RequestParam String firstName,@RequestParam String extension,@RequestParam String email,@RequestParam Integer officeCode,@RequestParam Integer reportsTo,@RequestParam String jobTitle) {
 

    Employees n = new Employees();
    n.setLastName(lastName);
    n.setFirstName(firstName);
    n.setExtension(extension);
    n.setEmail(email);
    n.setOfficeCode(officeCode);
    n.setReportsTo(reportsTo);
    n.setJobTitle(jobTitle);
    employeesrepository.save(n);
    return "redirect:/employees/all";
}

@GetMapping("/autocomplete")
	@ResponseBody
	public List<AutoComplete> autocomplete(@RequestParam String term) {
		List<AutoComplete> autoList = new ArrayList<AutoComplete>();
		List<Employees> employees = employeesrepository.findByPatternLike(term);
		for (Employees employee : employees) {
			AutoComplete item = new AutoComplete();
			item.setLabel(employee.getLastName() +" "+ employee.getFirstName());
			item.setValue(employee.getEmployeeNumber());
			autoList.add(item);
		}
		return autoList;
	}




}
