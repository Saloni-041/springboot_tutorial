package com.project.SpringBootApp.repository;

import com.project.SpringBootApp.model.Residence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenceRepository extends JpaRepository<Residence,Integer> {
}
