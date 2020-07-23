package com.employees.controllers;

import com.employees.entities.Employee;
import com.employees.entities.ManagerEmployee;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.RemunirationRepository;
import com.employees.services.DepartementService;
import com.employees.services.EmployeeService;
import com.employees.services.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RemunerationService remunerationService;
    @Autowired
    private DepartementService departementService;

    @GetMapping({"/add"})
    public String add(ModelMap model, ManagerEmployee employee, HttpServletRequest request) {
        model.addAttribute("departement", departementService.getAllDeps());
        model.addAttribute("remuneration", remunerationService.getAllRumuneration());
        model.addAttribute("employees", employee);
        return "employees/add";
    }

    @PostMapping("/saveManager")
    public String saveEmployee(@Valid @ModelAttribute("employees") ManagerEmployee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("departement", departementService.getAllDeps());
            model.addAttribute("remuneration", remunerationService.getAllRumuneration());
            model.addAttribute("employee",employee);
            return "employee/add";
        }
        employeeService.save(employee);
        return "redirect:/employee/";
    }
}
