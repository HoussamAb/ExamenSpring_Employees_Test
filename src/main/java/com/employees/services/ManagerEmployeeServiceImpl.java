package com.employees.services;

import com.employees.entities.ManagerEmployee;
import com.employees.entities.NormalEmployee;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.ManagerEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ManagerEmployeeServiceImpl implements ManageremployeeService {

    @Autowired
    private ManagerEmployeeRepository managerEmployeeRepository;

    @Override
    public List<ManagerEmployee> getAllManagerEmployee() {
        List<ManagerEmployee> all = managerEmployeeRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public ManagerEmployee findById(long id) throws ResourceNotFoundException {
        return managerEmployeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(ManagerEmployee employee) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        employee.setCreated(timestamp);
        employee.setModified(timestamp);
        employee.setScore(0);
        managerEmployeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        managerEmployeeRepository.deleteById(id);
    }
}
