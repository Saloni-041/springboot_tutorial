package com.project.SpringBootApp.exceptions;

// This exception can be thrown when the user tries to delete or update
// a customer record that doesn’t exist in the database.
public class NoSuchCustomerExistsException extends RuntimeException{
    private String message;
    public NoSuchCustomerExistsException(String msg)
    {
        super(msg);
        this.message=msg;
    }
}
