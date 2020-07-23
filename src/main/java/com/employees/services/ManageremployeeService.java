package com.employees.services;

import com.employees.entities.ManagerEmployee;
import com.employees.entities.NormalEmployee;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ManageremployeeService {
    public List<ManagerEmployee> getAllManagerEmployee();

    ManagerEmployee findById(long id) throws ResourceNotFoundException;

    void save(ManagerEmployee employee);

    void deleteById(long id);
}
