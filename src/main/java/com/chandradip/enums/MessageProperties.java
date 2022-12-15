package com.chandradip.enums;

import lombok.Getter;

public enum MessageProperties {

    //Success message
    FETCHED_EMPLOYEE("Employee Fetched Successfully!"),
    FETCHED_ALL_EMPLOYEE("All Employee Details Fetched Successfully!"),
    UPDATE_EMPLOYEE("Employee is updated successfully!"),
    DELETE_EMPLOYEE("Employee is deleted Successfully!"),


    //successMessages for address
    ADDED_ADDRESS("Address information are added Successfully!"),
    DELETE_ADDRESS("Address is deleted successfully!"),
    FETCHED_ADDRESS("Address Is Fetched Successfully"),
    FETCHED_ALL_ADDRESS("All Address are Fetched Successfully!"),
    UPDATE_ADDRESS("Address updated Successfully"),



    //Error message
    EMPLOYEE_NOT_FOUND("Employee is not Found!"),

    ADDRESS_NOT_FOUND("Address is not found!"),
    ;
    @Getter
    private String message;

     MessageProperties(String message) {
        this.message = message;
    }
}
