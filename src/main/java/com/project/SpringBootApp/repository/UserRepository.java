package com.project.SpringBootApp.repository;

import com.project.SpringBootApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// In the arguments we need to pass our model class and
// the second argument is the type of id we have used
// in our model class
public interface UserRepository extends JpaRepository<User,Integer> {
}
