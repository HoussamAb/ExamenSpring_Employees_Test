package com.employees.services;

import com.employees.entities.Departement;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDeps() {
        List<Departement> all = departementRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public Departement findById(long id) throws ResourceNotFoundException {
        return departementRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(Departement departement) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        departement.setCreated(timestamp);
        departementRepository.save(departement);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        departementRepository.deleteById(id);
    }
}
