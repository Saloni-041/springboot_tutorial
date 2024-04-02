package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.exceptions.CustomerAlreadyExistsException;
import com.project.SpringBootApp.model.Customer;
import com.project.SpringBootApp.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer)
    {
        return customerServiceImpl.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public String updateCustomer(@RequestBody Customer customer)
    {
        return customerServiceImpl.updateCustomer(customer);
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable Long id)
    {
        return customerServiceImpl.getCustomer(id);
    }

//.class is a way to refer to the Class object of the specified exception type in Java,
// and it is required when specifying the exception type in annotations like @ExceptionHandler.
    @ExceptionHandler(value = CustomerAlreadyExistsException.class)
//  Spring Boot allows to annotate a method with @ResponseStatus to return the required Http Status Code.
//  It sets the HTTP response status code to 409 (CONFLICT), It indicates that the response should signal a conflict,
//  which typically means that the requested operation cannot be performed because of a resource conflict
//  (in this case, a customer already exists).
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleCustomerAlreadyExistsException(CustomerAlreadyExistsException ex)
    {
        return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
    }
}
