package com.project.SpringBootApp.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@RestController
public class CustomErrorController implements ErrorController {

    @GetMapping("/format=page")
    public ResponseEntity<Object> page()
    {
//        URI.create() creates a new URI object which parses the webpage link as URI.
//        The location() method searches for the location of the URI to which the control is to be redirected.
//        HttpStatus.FOUND returns the response code which signifies whether the URL is reachable or not.
//        The build() method builds this entire stream of commands which is then processed by ResponseEntity.status.
//        This entire response is then returned by the Java function after which the control is redirected to the
//        given URL depending on the status code for the request.
        return  ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://www.geeksforgeeks.org/resource-injection-in-java-ee/")).build();
    }

    @GetMapping("/format=text")
    public HashMap<String,String> text()
    {
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd :HH:mm:ssZ");
//        The current date and time is stored in a variable using the command
//        “Date date = new Date(System.currentTimeMillis());”
        Date date=new Date(System.currentTimeMillis());
        String formatteedDate=formatter.format(date);
        HashMap<String,String> hp=new HashMap<>();
        hp.put("currentTime",formatteedDate);
        hp.put("status","OK");
        return hp;
    }

    @PostMapping("/**")
    public HashMap<String,String> all_except_get()
    {
        HashMap<String,String> hp=new HashMap<>();
        hp.put("status","401");
        return hp;
    }

//    Since the service is expected to handle only GET requests and a 405 error is to be shown for other requests,
//    (“/**”) is used after each annotation mapping to receive all requests for a given type
//    (POST, PUT, DELETE and PATCH) and throw the 405 error message.
    @PutMapping("/**")
    public HashMap<String,String> all_put()
    {
        HashMap<String,String> hp=all_except_get();
        return hp;
    }

    @DeleteMapping("/**")
    public HashMap<String,String> all_delete()
    {
        HashMap<String,String> hp=all_except_get();
        return hp;
    }
    @PatchMapping("/**")
    public HashMap<String,String> all_patch()
    {
        HashMap<String,String> hp=all_except_get();
        return hp;
    }

    @RequestMapping("/error")
    public ResponseEntity<Object> handleError()
    {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://salonibajajportfolio.netlify.app/")).build();
    }

    public String getErrorPath()
    {
        return "/error";
    }
}
