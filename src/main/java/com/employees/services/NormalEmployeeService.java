package com.employees.services;

import com.employees.entities.NormalEmployee;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface NormalEmployeeService {

    public List<NormalEmployee> getAllNormalEmployee();

    NormalEmployee findById(long id) throws ResourceNotFoundException;

    void save(NormalEmployee employee);

    void deleteById(long id);
}
