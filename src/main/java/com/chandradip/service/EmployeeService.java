package com.chandradip.service;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.EmployeeResponse;
import com.chandradip.dto.RequestDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest, List<AddressRequest> addressRequests);

    List<EmployeeResponse> getAllEmployee();

    EmployeeResponse updateEmployeeDetails(Integer employeeId, RequestDTO requestDTO);
}
