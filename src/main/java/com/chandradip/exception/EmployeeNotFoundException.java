package com.chandradip.exception;

public class EmployeeNotFoundException  extends RuntimeException{

    private String statusCode;

    public enum ExceptionType {
        EMPLOYEE_NOT_FOUND,
        EMPLOYEE_ALREADY_PRESET,
    }

    public EmployeeNotFoundException.ExceptionType type;

    public EmployeeNotFoundException(String msg, EmployeeNotFoundException.ExceptionType type, String statusCode) {
        super(msg);
        this.type = type;
        this.statusCode = statusCode;
    }
}
