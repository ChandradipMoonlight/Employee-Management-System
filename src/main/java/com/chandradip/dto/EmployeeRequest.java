package com.chandradip.dto;

import com.chandradip.enums.Department;
import com.chandradip.enums.Gender;
import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeFirstName;
    private String employeeLastName;
    private Integer EmployeeAge;
    private Gender gender;
    private Department department;
}
