package com.project.SpringBootApp.service;

import com.project.SpringBootApp.exceptions.CustomerAlreadyExistsException;
import com.project.SpringBootApp.exceptions.NoSuchCustomerExistsException;
import com.project.SpringBootApp.model.Customer;
import com.project.SpringBootApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer getCustomer(Long id) {
        Customer getCustomer=customerRepository.findById(id).orElse(null);
        if(getCustomer!=null)
            return getCustomer;
        else
            throw new NoSuchElementException("No customer present with id = "+id);
    }

    public String addCustomer(Customer customer) {
//        Optional<Customer> getCustomer=customerRepository.findById(customer.getId());
//        if(getCustomer==null)
//        {
//            customerRepository.save(customer);
//            return "Customer added successfully";
//        }
//        else{
//            throw  new CustomerAlreadyExistsException("Customer already exists!!");
//        }
        Customer existingCustomer = customerRepository.findById(customer.getId()).orElse(null);
        if (existingCustomer == null) {
            customerRepository.save(customer);
            return "Customer added successfully";
        }
        else
            throw new CustomerAlreadyExistsException(
                    "Customer already exists!!");
    }

    @Override
    public String updateCustomer(Customer customer) {
        Customer getCustomer=customerRepository.findById(customer.getId()).orElse(null);
        if(getCustomer==null)
        {
            throw new NoSuchCustomerExistsException("No Such Customer exists!!");
        }
        else
        {
//            Customer updateCustomer=getCustomer.get();
            getCustomer.setName(customer.getName());
            getCustomer.setAddress(customer.getAddress());
            customerRepository.save(getCustomer);
            return "Record updated Successfully";
        }
    }
}
