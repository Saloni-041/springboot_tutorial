package com.project.SpringBootApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/get")
public class PathVariableController {
    @GetMapping("/user/{name}/{age}")
    public String display(@PathVariable ("name")String name,@PathVariable ("age") String age)
    {
        return name +" "+ age;
//        System.out.println(age);
    }
}
