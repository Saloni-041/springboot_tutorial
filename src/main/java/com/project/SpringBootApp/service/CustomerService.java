package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.Customer;

public interface CustomerService {
    Customer getCustomer(Long id);
    String addCustomer(Customer customer);
    String updateCustomer(Customer customer);
}
