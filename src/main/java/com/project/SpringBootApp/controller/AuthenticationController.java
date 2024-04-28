package com.project.SpringBootApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/auth")
public class AuthenticationController {
    @GetMapping("/welcome")
    public String welcome()
    {
        return "Hi, welcome to the spring boot application!";
    }
}

