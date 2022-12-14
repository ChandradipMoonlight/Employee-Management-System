package com.chandradip.exception;

public class AddressNotFoundException extends RuntimeException{
    private String statusCode;
    public enum ExceptionType {
        ADDRESS_NOT_FOUND,
    }

    public AddressNotFoundException.ExceptionType type;

    public AddressNotFoundException(String msg, AddressNotFoundException.ExceptionType type, String statusCode) {
        super(msg);
        this.type = type;
        this.statusCode = statusCode;
    }
}
