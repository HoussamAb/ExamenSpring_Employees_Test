package com.employees.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ManagerEmployee extends Employee {


    public ManagerEmployee(long id,String name,String address, String phone,int grade, int score, Departement departement,Remuneration remuneration,List<NormalEmployee> normalEmployeeList){
        super(id,name,address,phone,grade,score,departement,remuneration);
        setSousAdjacents(normalEmployeeList);
    }

    @Override
    public void setSousAdjacents(List<NormalEmployee> normalEmployeeList) {
        this.normalEmployees = normalEmployeeList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(cascade=CascadeType.ALL)
    List<NormalEmployee> normalEmployees;


}
