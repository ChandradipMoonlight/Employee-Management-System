package com.chandradip.controller;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.ResponseDTO;
import com.chandradip.enums.MessageProperties;
import com.chandradip.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@Slf4j
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add/employee/{empId}")
    public ResponseEntity<ResponseDTO> addAddress(@PathVariable("empId") Integer empId, @RequestBody AddressRequest request) {
        ResponseDTO response = new ResponseDTO(MessageProperties.ADDED_ADDRESS.getMessage(),
                addressService.addAddress(empId, request));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
