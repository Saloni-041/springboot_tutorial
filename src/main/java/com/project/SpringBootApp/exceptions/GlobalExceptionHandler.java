package com.project.SpringBootApp.exceptions;

import com.project.SpringBootApp.controller.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//if we want to handle any exception thrown throughout the application
// we can define a global exception handler class and annotate it with
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = NoSuchCustomerExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleNoSuchCustomerExistsException(NoSuchCustomerExistsException ex)
    {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage() );
    }
}
