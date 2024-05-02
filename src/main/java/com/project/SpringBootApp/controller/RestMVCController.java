package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.UserModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.SessionAttributes;

@RestController
//This annotation declares that the attribute named "userModel" should be stored in the session.
// This means that the "userModel" attribute will be available across multiple requests within the same session.
@SessionAttributes("userModel")
@RequestMapping(path="/Rest", produces="application/json")
//Enables Cross-Origin Resource Sharing (CORS) for this controller, allowing requests from any origin (*).
// This is useful when your REST API needs to be accessed from different domains.
@CrossOrigin(origins="*")
public class RestMVCController {

    @GetMapping
//    This annotation indicates that the controller expects to retrieve an attribute named "message" from
//    the session and bind it to the UserModel object named user.
    public UserModel get(@ModelAttribute("message") UserModel user, SessionStatus sessionStatus) {

        // cleans up the stored
        // session attributes (data)
        sessionStatus.setComplete();
        return user;
    }
}
