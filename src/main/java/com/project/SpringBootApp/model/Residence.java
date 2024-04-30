package com.project.SpringBootApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cityname;
    @ManyToOne
    @JoinColumn(name="Student_id")
//    this annotation specifies the name of the foreign key column in the Residence table that references the primary key
//    column of the Student table.In this case, Student_id is the name of the column in the Address table that will hold
//    the foreign key values referencing the primary key column of the Student table.So, when Hibernate generates the
//    schema for the Address table, it will include a column named Student_id which will serve as the
//    foreign key to establish the many-to-one relationship with the Student table. This column will hold the IDs
//    of the associated students for each address record.
      Student student;

}
