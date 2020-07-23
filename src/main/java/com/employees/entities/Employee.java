package com.employees.entities;
import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="employee")
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    String address;

    String phone;

    int grade;

    int score;

    @Column(name="created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @Column(name="modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @ManyToOne(fetch= FetchType.EAGER)
    Departement departement;

    @ManyToOne(fetch= FetchType.EAGER)
    Remuneration remuneration;

    @ManyToOne(fetch= FetchType.EAGER)
    User user;

    public Employee(long id,String name, String address, String phone,int grade, int score, Departement departement, Remuneration remuneration) {
        this.id=id;
        this.name = name;
        this.address= address;
        this.phone = phone;
        this.grade = grade;
        this.score = score;
        this.departement = departement;
        this.remuneration = remuneration;
    }

    public void addScore(){
        this.score++;
    }

    public void subbsScore(){
        this.score--;
    }

    public void reinitialiseScore(){
        this.score = 0;
    }

    public abstract void setSousAdjacents(List<NormalEmployee> normalEmployeeList);

    public void  managerToNormal(ManagerEmployee managerEmployee){
        NormalEmployee normalEmployee = new NormalEmployee();
        normalEmployee.setScore(managerEmployee.getScore());
        normalEmployee.setAddress(managerEmployee.getAddress());
        normalEmployee.setGrade(managerEmployee.getGrade());
        normalEmployee.setName(managerEmployee.getName());
        normalEmployee.setPhone(managerEmployee.getPhone());
        normalEmployee.setDepartement(managerEmployee.getDepartement());
        normalEmployee.setRemuneration(managerEmployee.getRemuneration());
        normalEmployee.setCreated(managerEmployee.getCreated());
        normalEmployee.setModified(new Timestamp(System.currentTimeMillis()));
    };

    public String type() {
       Class<?> employeeClass = this.getClass();
       if(employeeClass.getName() == "com.employees.entities.ManagerEmployee"){
           return "manager";
       }else if (employeeClass.getName() == "com.employees.entities.NormalEmployee"){
           return "normal";
       }else{
           return "non reconnue";
       }
    }
}

