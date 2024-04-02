package com.project.SpringBootApp.exceptions;

public class NoSuchCustomerExistsException extends RuntimeException{
    private String message;
    public NoSuchCustomerExistsException(String msg)
    {
        super(msg);
        this.message=msg;
    }
}
