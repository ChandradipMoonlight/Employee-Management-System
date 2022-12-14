package com.chandradip.dto;

import com.chandradip.enums.Department;
import com.chandradip.enums.Gender;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private ResponseStatus responseStatus;
    private Integer employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private Integer employeeAge;
    private Gender gender;
    private Department department;
    private String employeeEmailId;
    private String employeeMobileNumber;
    private String employeeCreatedDate;
    private String employeeUpdatedDate;

    List<AddressResponse> addressResponses;

}
