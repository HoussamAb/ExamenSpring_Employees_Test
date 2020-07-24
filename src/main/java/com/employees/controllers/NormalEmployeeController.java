package com.employees.controllers;

import com.employees.entities.ManagerEmployee;
import com.employees.entities.NormalEmployee;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.formaters.departementFormater;
import com.employees.formaters.normalEmployeeFormater;
import com.employees.formaters.remunerationFormater;
import com.employees.services.DepartementService;
import com.employees.services.ManageremployeeService;
import com.employees.services.NormalEmployeeService;
import com.employees.services.RemunerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/normal/employee")
public class NormalEmployeeController {

    @Autowired
    private RemunerationService remunerationService;
    @Autowired
    private DepartementService departementService;
    @Autowired
    private NormalEmployeeService normalEmployeeService;
    @Autowired
    private ManageremployeeService manageremployeeService;

    @InitBinder
    private void customizeBinding (WebDataBinder binder) {
        binder.registerCustomEditor(String.class,"departement", new departementFormater());
        binder.registerCustomEditor(String.class,"remuneration", new remunerationFormater());
        binder.registerCustomEditor(String.class,"normalEmployees", new normalEmployeeFormater());
    }

    @GetMapping({"/add"})
    public String add(ModelMap model, ManagerEmployee employee, HttpServletRequest request) {
        model.addAttribute("departement", departementService.getAllDeps());
        model.addAttribute("remuneration", remunerationService.getAllRumuneration());
        model.addAttribute("normalEmployees", normalEmployeeService.getAllNormalEmployee());
        model.addAttribute("employees", employee);
        return "employees/addNormal";
    }

    @PostMapping("/saveNormal")
    public String saveEmployee(@Valid @ModelAttribute("employees") NormalEmployee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("departement", departementService.getAllDeps());
            model.addAttribute("remuneration", remunerationService.getAllRumuneration());
            model.addAttribute("employee",employee);
            return "employees/addNormal";
        }
            normalEmployeeService.save(employee);
        return "redirect:/home";
    }
    @GetMapping({"/edit/{id}"})
    public String edit(@PathVariable("id") long id, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        model.addAttribute("managers", manageremployeeService.getAllManagerEmployee());
        model.addAttribute("departement", departementService.getAllDeps());
        model.addAttribute("remuneration", remunerationService.getAllRumuneration());
        model.addAttribute("employees",normalEmployeeService.findById(id));
        return "employees/EditEmployee";
    }

    @PostMapping({"/edit"})
    public String postEdit(@Valid @ModelAttribute("employees") NormalEmployee employee, BindingResult result, ModelMap model, HttpServletRequest request) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("departement", departementService.getAllDeps());
            model.addAttribute("remuneration", remunerationService.getAllRumuneration());
            model.addAttribute("employee",employee);
            return "employees/addNormal";
        }
        // normalEmployeeService.updateById(employee.getId(),employee.getManagers());
        normalEmployeeService.save(employee);
        return "employees/addNormal";
    }
}
