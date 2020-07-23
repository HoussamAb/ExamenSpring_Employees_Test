package com.employees.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class NormalEmployee extends Employee {

    public NormalEmployee(long id,String name,String address, String phone,int grade, int score, Departement departement,Remuneration remuneration){
        super(id,name,address,phone,grade,score,departement,remuneration);
    }

    @Override
    public void setSousAdjacents(List<NormalEmployee> normalEmployeeList) {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
}
