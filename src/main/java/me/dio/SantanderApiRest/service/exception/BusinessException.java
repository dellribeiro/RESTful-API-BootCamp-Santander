package me.dio.SantanderApiRest.service.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String message){
        super(message);
    }

}
