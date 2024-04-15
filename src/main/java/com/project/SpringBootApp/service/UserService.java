package com.project.SpringBootApp.service;


import com.project.SpringBootApp.model.User;
import com.project.SpringBootApp.model.UserDto;

public interface UserService {
    public User createUser(User user);
    public UserDto getUser(int id);

}
