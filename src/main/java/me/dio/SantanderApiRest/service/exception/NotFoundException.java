package me.dio.SantanderApiRest.service.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Resource not found.");
    }
}
