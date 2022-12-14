package com.chandradip.dto;

import com.chandradip.enums.Department;
import com.chandradip.enums.Gender;
import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmailId;
    private String employeeMobileNumber;
    private Integer employeeAge;
    private Gender gender;
    private Department department;
}
