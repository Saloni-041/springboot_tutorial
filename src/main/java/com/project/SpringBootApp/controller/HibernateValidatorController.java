package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.HibernateValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/hibernateValidator")
public class HibernateValidatorController {
    @PostMapping("/create")
    public ResponseEntity<HibernateValidator> create(@Valid @RequestBody HibernateValidator hibernateValidator)
    {
        return new ResponseEntity<>(hibernateValidator, HttpStatus.CREATED);
    }
}
//@Valid – This annotation we check for all the validators applied to each field.