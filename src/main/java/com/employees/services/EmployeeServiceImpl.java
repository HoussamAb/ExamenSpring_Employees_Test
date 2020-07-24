package com.employees.services;

import com.employees.entities.Employee;
import com.employees.entities.ManagerEmployee;
import com.employees.entities.NormalEmployee;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.EmployeeRepository;
import com.employees.repositories.ManagerEmployeeRepository;
import com.employees.repositories.NormalEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerEmployeeRepository managerEmployeeRepository;
    @Autowired
    private NormalEmployeeRepository normalEmployeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Employee findById(long id) throws ResourceNotFoundException {
        NormalEmployee  normalEmployee = null;
        ManagerEmployee managerEmployee = null ;
        try {
            managerEmployee = managerEmployeeRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException(id)
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            normalEmployee = normalEmployeeRepository.findById(id).orElseThrow(
                    ()->new ResourceNotFoundException(id)
            );
        }catch (Exception e){
            e.printStackTrace();
        }

        if(managerEmployee == null){
            System.out.println("normal: "+normalEmployee);
            return normalEmployee;
        }else{
            System.out.println("manager: "+managerEmployee);
            return managerEmployee;
        }
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
