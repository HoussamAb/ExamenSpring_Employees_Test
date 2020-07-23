package com.employees.services;

import com.employees.entities.Employee;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployee();

    Employee findById(long id) throws ResourceNotFoundException;

    void save(Employee employee);

    void deleteById(long id);
}
