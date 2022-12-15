package com.chandradip.controller;

import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.ResponseDTO;
import com.chandradip.enums.MessageProperties;
import com.chandradip.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeeById(@PathVariable("empId") Integer empId, @RequestBody EmployeeRequest request) {
        log.info("Inside Employee Controller updateEmployeeById() method, EmployeeId : {empId}", empId);
        ResponseDTO response = new ResponseDTO(MessageProperties.UPDATE_EMPLOYEE.getMessage(),
                employeeService.updateEmployeeById(empId, request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeeById(@PathVariable("empId") Integer empId) {
        log.info("Inside EmployeeController deleteEmployee() method. [Employee Id] : => {}", empId);
        ResponseDTO response = new ResponseDTO(MessageProperties.DELETE_EMPLOYEE.getMessage(),
                employeeService.deleteEmployeeById(empId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
