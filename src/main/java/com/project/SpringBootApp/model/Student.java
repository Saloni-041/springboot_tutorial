package com.project.SpringBootApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollno;
    private String name;

    @OneToMany(cascade= CascadeType.ALL)   //means that any operations performed on the StudentInformation entity will also affect associated Residence entities.
    private Set<Residence> res;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
}
