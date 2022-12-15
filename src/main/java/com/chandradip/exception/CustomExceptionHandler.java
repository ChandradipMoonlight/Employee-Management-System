package com.chandradip.exception;

import com.chandradip.dto.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseStatus> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        ResponseStatus status = new ResponseStatus(e.getMessage(), e.getStatusCode());
        return new ResponseEntity<>(status, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<ResponseStatus> handleAddressNotFoundException(AddressNotFoundException e) {
        ResponseStatus responseStatus = new ResponseStatus(e.getMessage(), e.getStatusCode());
        return new ResponseEntity<>(responseStatus, HttpStatus.BAD_REQUEST);
    }
}
