package com.employees.services;

import com.employees.entities.Employee;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Employee findById(long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        employeeRepository.deleteById(id);
    }
}
