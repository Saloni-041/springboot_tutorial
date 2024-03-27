package com.project.SpringBootApp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="ADD_INFO")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    @OneToOne                     // one to one mapping means,one employee stays at one address only
    private Employee employee;    // in db employee_id col will be made in table add_info
    //alter table add_info add constraint FKm3qr2u1jsypowcg8lj6vhesii foreign key (employee_id) references emp_info
}
