package com.chandradip.exception;


import lombok.Getter;

public class AddressNotFoundException extends RuntimeException {
    @Getter
    private String statusCode;

    public AddressNotFoundException(String msg, String statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }
}
