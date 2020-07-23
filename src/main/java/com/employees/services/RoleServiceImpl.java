package com.employees.services;

import com.employees.entities.Role;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class RoleServiceImpl implements RoleService {

    @Qualifier("roleRepository")
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllroles() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(long id) throws ResourceNotFoundException {
        return roleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(long id) {
        roleRepository.deleteById(id);
    }
}
