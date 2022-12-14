package com.chandradip.service;

import com.chandradip.dto.EmployeeRequest;
import com.chandradip.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommonService {

    public Employee updateEmployee(Employee employee, EmployeeRequest employeeRequest) {
        log.info("Inside CommonService Class updateEmployee() method.");
        if (employeeRequest.getEmployeeFirstName() != null) {
            employee.setFirstName(employeeRequest.getEmployeeFirstName());
        }
        if (employeeRequest.getEmployeeLastName()!= null) {
            employee.setLastName(employeeRequest.getEmployeeLastName());
        }
        if (employeeRequest.getEmployeeAge() != null) {
            employee.setAge(employeeRequest.getEmployeeAge());
        }
        if (employeeRequest.getEmployeeEmailId() != null) {
            employee.setEmailId(employeeRequest.getEmployeeEmailId());
        }
        if (employeeRequest.getEmployeeMobileNumber() != null) {
            employee.setMobileNumber(employeeRequest.getEmployeeMobileNumber());
        }
        if (employeeRequest.getGender() != null) {
            employee.setGender(employeeRequest.getGender().name());
        }
        if (employeeRequest.getDepartment() != null) {
            employee.setDepartment(employeeRequest.getDepartment().name());
        }
        return employee;
    }
}
