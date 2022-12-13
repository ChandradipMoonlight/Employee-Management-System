package com.chandradip.dto;

import com.chandradip.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {
    private Integer addressId;
    private String city;
    private String state;
    private String pinCode;
    private AddressType addressType;
    private String addressCreatedDate;
    private String addressUpdatedDate;

//    private EmployeeResponse employeeResponse;
}
