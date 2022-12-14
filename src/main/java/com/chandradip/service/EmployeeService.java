package com.chandradip.service;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse getEmployeeById(Integer employeeId);

    EmployeeResponse updateEmployeeById(Integer empId, EmployeeRequest request);

    Integer deleteEmployeeById(Integer empId);
}
