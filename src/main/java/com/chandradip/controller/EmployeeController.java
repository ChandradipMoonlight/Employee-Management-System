package com.chandradip.controller;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.RequestDTO;
import com.chandradip.dto.ResponseDTO;
import com.chandradip.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> addEmployee(@RequestBody RequestDTO request) {
        log.info("[Request] : {}", request);
        ResponseDTO responseDTO = new ResponseDTO("Employee is Added!",
                employeeService.addEmployee(request.getEmployeeRequest(), request.getAddressRequests()));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }


}
