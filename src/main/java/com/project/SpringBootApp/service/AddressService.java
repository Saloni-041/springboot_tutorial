package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.Address;
import com.project.SpringBootApp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address addAddress(Address address)
    {
        Address addressSavedToDB=addressRepository.save(address);
        return addressSavedToDB;
    }
}
