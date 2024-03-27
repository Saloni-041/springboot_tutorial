package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.Address;
import com.project.SpringBootApp.model.Employee;
import com.project.SpringBootApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressService addressService;

    @Transactional
    //You can use @Transactional annotation in service layer which will result interacting with the database.
   //This will ensure that the transaction should be complete. That is, either both employee and address data should be stored or nothing will get stored. For using transaction management, we need to use @EnableTransactionManagement in the main class of our spring boot application
    public Employee addEmployee(Employee employee) throws Exception
    {
        Employee employeeSavedToDB=employeeRepository.save(employee);

        Address address=null;
        // if we initialize address object as null and requested the application, we have an employee created in the database but the address information is not, as we have received a null pointer exception. But, this is not good practice in transaction management, as employees should be saved only when the address is saved and vice-versa.
        address.setId(123L);
        address.setAddress("Varanasi");
        address.setEmployee(employee);

        addressService.addAddress(address);

        return employeeSavedToDB;
    }
}
