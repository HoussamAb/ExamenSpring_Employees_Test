package com.employees.services;


import com.employees.entities.Role;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface RoleService {
    public List<Role> getAllroles();

    Role findById(long id) throws ResourceNotFoundException;

    void save(Role role);

    void deleteById(long id);
}
