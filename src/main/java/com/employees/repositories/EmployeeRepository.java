package com.employees.repositories;

import com.employees.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();


    /*@Query("select a from ManagerEmployee a left join fetch a. where a. id=:id")
    Employee findByIdWith(@Param("id") long id);*/
}
