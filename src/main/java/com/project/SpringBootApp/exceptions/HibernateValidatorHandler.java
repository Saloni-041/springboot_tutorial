package com.project.SpringBootApp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
//This annotation is used to define global exception handlers in a Spring MVC application.
// It allows you to consolidate your exception handling logic in one place.
public class HibernateValidatorHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Map<String,Object> map=new LinkedHashMap<>();
        map.put("Current Time",new Date());
        map.put("Status",status.value());

        List<String> list=ex.getBindingResult().getFieldErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
        map.put("Errors",list);

        return new ResponseEntity<>(map,status);
    }
}
