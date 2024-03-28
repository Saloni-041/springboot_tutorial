package com.project.SpringBootApp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
public class HibernateValidator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Id can't be null")
    private Integer id;

    @NotEmpty(message = "PhnNo can't be empty and null")
    private String phnno;

    @NotBlank(message = "Name can't be left blank")
    private  String name;

    @Min(value = 18,message = "Minimum age is 18")
    @Max(value=60,message = "Maximum age is 60")
    private Integer age;

    @Email(message = "Please enter valid email address")
    @NotNull(message = "Email cannot be null")
    private String email;

    @Pattern(regexp = "^[0-9]{5}$",message = "Postal code must be a 5-digit number")
    private String postalCode;

    @Size(min = 10,max = 100,message = "Address should have a length between 10 and 100 characters")
    private String address;    //Size can be used to add a constraint of length to any field.
}
