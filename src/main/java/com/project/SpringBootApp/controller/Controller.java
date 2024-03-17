package com.project.SpringBootApp.controller;

import com.project.SpringBootApp.model.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller
{
    ArrayList<Integer> al;

    Controller()
    {
        al=new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
    }
    @GetMapping("/")  //if we don't add value that means home page only
    public String home()
    {
       return "Hello people!";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/info") //we can skip the data present in bracket if we want to show data on home page
    public String info()
    {
        return "My name is Saloni Bajaj";
    }

    @GetMapping("/callClientInfo")
    public String getInfoClient()
    {
        String uri="http://localhost:8080/info";
        RestTemplate restTemplate=new RestTemplate();
        // Rest Template is the central Spring class used to create applications that consume RESTful Web Services.
        // You can use the methods available in the Rest Template class to consume the web services for all HTTP methods.
        String result=restTemplate.getForObject(uri,String.class);
        return result;
    }

    @GetMapping("/callClientInfo2")
    public String  getCountries()
    {
        String url="https://www.geeksforgeeks.org/spring-boot/";
        RestTemplate restTemplate=new RestTemplate();
        String result= restTemplate.getForObject(url, String.class);
        return result;
    }

    @GetMapping("/personDetails")
    public void getBody(@RequestBody Person person)
    {
        System.out.println(person);
    }

    @PutMapping("/change/{id}")
    public void change(@PathVariable int id)  //id=1
    {
        System.out.println(al);
        al.remove(id);                  //remove element present at 1
        al.set(id,45);                 //set element at position 1
        System.out.println(al);
    }
}
