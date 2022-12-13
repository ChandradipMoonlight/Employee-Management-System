package com.chandradip.service;

import com.chandradip.builder.EmployeeBuilder;
import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.EmployeeResponse;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.repo.AddressRepo;
import com.chandradip.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private EmployeeBuilder employeeBuilder;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest, List<AddressRequest> addressRequests) {
        log.info("Inside EmployeeServiceImpl class addEmployee() method!");
        Employee employee = employeeBuilder.getEmployee(employeeRequest);
        log.info("Employee Entity Object is created!, [Employee] => {}", employee);
        List<Address> address = employeeBuilder.getAddress(addressRequests, employee);
        log.info("Address Entity Object is create!, [List<Address>] => {}", address);
        employee = employeeRepo.save(employee);
        log.info("Saved Employee!, [Employee] => {}", employee);
        address = addressRepo.saveAll(address);
        log.info("Saved Address!, [Address] => {}", address);
        EmployeeResponse employeeResponse = employeeBuilder.getEmployeeResponse(employee, address);
        log.info("[Employee Response] : {}",employeeResponse);
        return employeeResponse;
    }
}
