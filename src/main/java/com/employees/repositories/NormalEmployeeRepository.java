package com.employees.repositories;

import com.employees.entities.Employee;
import com.employees.entities.ManagerEmployee;
import com.employees.entities.NormalEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NormalEmployeeRepository extends JpaRepository<NormalEmployee, Long> {
    Page<NormalEmployee> findAll(Pageable pageable);
    List<NormalEmployee> findAll();
    @Modifying
    @Query("update Employee set ManagerEmployee =:employee where id=:id")
    void updateById(@Param("id") long id, @Param("employee") ManagerEmployee employee);
}
