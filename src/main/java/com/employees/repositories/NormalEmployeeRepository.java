package com.employees.repositories;

import com.employees.entities.Employee;
import com.employees.entities.NormalEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NormalEmployeeRepository extends JpaRepository<NormalEmployee, Long> {
    Page<NormalEmployee> findAll(Pageable pageable);
    List<NormalEmployee> findAll();

}
