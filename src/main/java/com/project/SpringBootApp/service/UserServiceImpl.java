package com.project.SpringBootApp.service;

import com.project.SpringBootApp.model.User;
import com.project.SpringBootApp.model.UserDto;
import com.project.SpringBootApp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User createUser(User user) {
        User userSavedToDB=userRepository.save(user);
        return userSavedToDB;
    }

    @Override
    public UserDto getUser(int id) {
        User user=userRepository.findById(id).get();
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return userDto;
    }
}
