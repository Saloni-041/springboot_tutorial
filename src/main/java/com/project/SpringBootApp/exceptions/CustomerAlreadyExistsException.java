package com.project.SpringBootApp.exceptions;

//This exception can be thrown when the user tries to add a customer that already exists in the database
public class CustomerAlreadyExistsException extends RuntimeException{
    private String message;
    public CustomerAlreadyExistsException(String msg)
    {
        super(msg);
        this.message=msg;
    }
}
