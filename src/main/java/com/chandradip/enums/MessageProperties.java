package com.chandradip.enums;

import lombok.Getter;

public enum MessageProperties {

    //Success message
    FETCHED_EMPLOYEE("Employee Fetched Successfully!"),
    FETCHED_ALL_EMPLOYEE("All Employee Details Fetched Successfully!"),
    UPDATE_EMPLOYEE("Employee is updated successfully!"),
    DELETE_EMPLOYEE("Employee is deleted Successfully!"),

    //Error message
    EMPLOYEE_NOT_FOUND("Employee is not Found!"),
    ;
    @Getter
    private String message;

     MessageProperties(String message) {
        this.message = message;
    }
}
