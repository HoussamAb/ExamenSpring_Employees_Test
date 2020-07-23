package com.employees.controllers;

import com.employees.entities.Employee;
import com.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping({"/","home"})
    public ModelAndView home(@PathVariable(name="id",required = false) Optional<Integer> id, ModelMap model)
    {
        List<Employee> employees = employeeService.getAllEmployee();
        ModelAndView map = new ModelAndView("home");
        map.addObject("data", employees);
        for(Employee a : employees){
            System.out.println(a.getId());
            System.out.println(a.getName());
            System.out.println(a.getPhone());
            System.out.println(a.getAddress());
            System.out.println(a.getDepartement());
            System.out.println(a.getRemuneration());
            System.out.println("type :"+a.type());

        }
        return map;
    }
}
