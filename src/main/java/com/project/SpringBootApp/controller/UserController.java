package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.User;
import com.project.SpringBootApp.model.UserDto;
import com.project.SpringBootApp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User userCreated=userServiceImpl.createUser(user);
        return new ResponseEntity<>(userCreated,HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name="id") int id)
    {
        UserDto userDto=userServiceImpl.getUser(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
