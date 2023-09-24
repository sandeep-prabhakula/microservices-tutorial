package com.sandeepprabhakula.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resource Not found");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
