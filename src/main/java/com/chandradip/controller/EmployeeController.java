package com.chandradip.controller;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.RequestDTO;
import com.chandradip.dto.ResponseDTO;
import com.chandradip.enums.MessageProperties;
import com.chandradip.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeeRequest request) {
        log.info("[Request] : {}", request);
        ResponseDTO responseDTO = new ResponseDTO("Employee is Added!",
                employeeService.addEmployee(request));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO> getAllEmployeeDetails() {
        ResponseDTO responseDTO = new ResponseDTO("All Employee Fetched Successfully!",
                employeeService.getAllEmployee());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeeById(@PathVariable("empId") Integer employeeId) {
        log.info("Inside Employee Controller getEmployeeById() method, EmployeeId : {}", employeeId);
        ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_EMPLOYEE.getMessage(),
                employeeService.getEmployeeById(employeeId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
