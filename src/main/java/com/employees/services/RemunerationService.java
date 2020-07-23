package com.employees.services;

import com.employees.entities.Departement;
import com.employees.entities.Remuneration;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RemunerationService {

    public List<Remuneration> getAllRumuneration();

    Remuneration findById(long id) throws ResourceNotFoundException;

    void save(Remuneration remuneration);

    void deleteById(long id);
}
