package com.chandradip.enums;

import lombok.Getter;

public enum MessageProperties {
    EMPLOYEE_ADDED("Employee Added Successfully"),
    FETCHED_EMPLOYEE("Details of all Employee is Fetched Successfully!"),
    UPDATED_EMPLOYEE("Employee Details are Updated Successfully!"),
    DELETED_EMPLOYEE("Employee Deleted Successfully!"),

    EMPLOYEE_NOT_FOUND("Employee is not found!"),
    ADDRESS_NOT_FOUND("Address is not found!"),
    ;

    @Getter
    private String message;

    MessageProperties(String message) {
        this.message = message;
    }
}
