package com.project.SpringBootApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String name;
    private String email;
}
//User and UserDto classes should have similar field names that you want to map.
//UserDto helps in showing only fields which we want to show.
//Although, we will create a new User with all the fields but will send only the required fields to the web layer.