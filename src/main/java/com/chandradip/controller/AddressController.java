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

    @GetMapping("/getAllByEmployee/{empId}")
    public ResponseEntity<ResponseDTO> getAllAddressByEmployee(@PathVariable("empId") Integer empId) {
        ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_ADDRESS.getMessage(),
                addressService.getAllAddressByEmployee(empId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllAddress() {
        ResponseDTO response = new ResponseDTO(MessageProperties.FETCHED_ALL_ADDRESS.getMessage(),
                addressService.getAllAddress());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/update/{addressId}")
    public ResponseEntity<ResponseDTO> updateAddressById(@PathVariable("addressId") Integer addressId, @RequestBody AddressRequest request) {
        ResponseDTO response = new ResponseDTO(MessageProperties.UPDATE_ADDRESS.getMessage(),
                addressService.updateAddressById(addressId, request));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<ResponseDTO> deleteAddressById(@PathVariable("addressId") Integer addressId) {
        ResponseDTO response = new ResponseDTO(MessageProperties.DELETE_ADDRESS.getMessage(),
                addressService.deleteAddressById(addressId));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
