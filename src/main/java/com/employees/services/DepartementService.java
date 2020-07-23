package com.employees.services;

import com.employees.entities.Departement;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface DepartementService {

    public List<Departement> getAllDeps();

    Departement findById(long id) throws ResourceNotFoundException;

    void save(Departement departement);

    void deleteById(long id);
}
