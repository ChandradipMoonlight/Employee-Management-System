package com.chandradip.exception;

import lombok.Getter;

public class EmployeeException extends RuntimeException{

    @Getter
    private String statusCode;

    public enum ExceptionType {
        EMPLOYEE_NOT_FOUND,
    }

    public EmployeeException.ExceptionType type;

    public EmployeeException(String msg, EmployeeException.ExceptionType type, String statusCode) {
        super(msg);
        this.type = type;
        this.statusCode = statusCode;
    }
}
