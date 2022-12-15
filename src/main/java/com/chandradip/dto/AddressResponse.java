package com.chandradip.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponse {
    private ResponseStatus responseStatus;
    private AddressDTO addressDTO;
    private EmployeeDTO employeeDTO;
}
