package com.project.SpringBootApp.repository;

import com.project.SpringBootApp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
