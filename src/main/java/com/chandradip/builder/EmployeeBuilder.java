package com.chandradip.builder;

import com.chandradip.dto.*;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.AddressType;
import com.chandradip.enums.Department;
import com.chandradip.enums.Gender;
import com.chandradip.repo.EmployeeRepo;
import com.chandradip.utils.AppUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmployeeBuilder {
    private final EmployeeRepo employeeRepo;

    public EmployeeBuilder(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee getEmployee(EmployeeRequest employeeRequest) {
        return Employee.builder()
                .firstName(employeeRequest.getEmployeeFirstName())
                .lastName(employeeRequest.getEmployeeLastName())
                .emailId(employeeRequest.getEmployeeEmailId())
                .mobileNumber(employeeRequest.getEmployeeMobileNumber())
                .age(employeeRequest.getEmployeeAge())
                .gender(employeeRequest.getGender().name())
                .department(employeeRequest.getDepartment().name())
                .build();
    }

    public EmployeeResponse getEmployeeResponse(Employee employee) {
        boolean isDataSaved = Optional.ofNullable(employee).isPresent();
        ResponseStatus responseStatus = isDataSaved ? AppUtils.getSuccessStatus() : AppUtils.getErrorStatus();
        List<AddressResponse> addressResponseList = null;
        if (employee.getAddresses() != null) {
            addressResponseList = getAddressResponse(employee.getAddresses());
        }
        return EmployeeResponse.builder()
                .employeeId(employee.getEmpId())
                .employeeFirstName(employee.getFirstName())
                .employeeLastName(employee.getLastName())
                .employeeAge(employee.getAge())
                .employeeEmailId(employee.getEmailId())
                .employeeMobileNumber(employee.getMobileNumber())
                .department(Department.valueOf(employee.getDepartment()))
                .gender(Gender.valueOf(employee.getGender()))
                .employeeCreatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .employeeUpdatedDate(AppUtils.getStringFormattedDate(employee.getCreatedDate()))
                .addressResponses(addressResponseList)
                .responseStatus(responseStatus)
                .build();
    }

    public List<AddressResponse> getAddressResponse(List<Address> address) {
         return address.stream().map(e -> {
            return AddressResponse.builder()
                    .addressId(e.getAddressId())
                    .state(e.getState())
                    .city(e.getCity())
                    .pinCode(e.getPinCode())
                    .addressType(AddressType.valueOf(e.getAddressType()))
                    .addressCreatedDate(AppUtils.getStringFormattedDate(e.getCreatedDate()))
                    .addressUpdatedDate(AppUtils.getStringFormattedDate(e.getUpdatedDate()))
                    .build();
         }).collect(Collectors.toList());
    }

    public List<Address> getAddress(List<AddressRequest> addressRequests, Employee employee) {
        return addressRequests.stream().
                map(addressRequest -> {
                    return Address.builder()
                            .city(addressRequest.getCity())
                            .state(addressRequest.getState())
                            .addressType(addressRequest.getAddressType().name())
                            .pinCode(addressRequest.getPinCode())
                            .employee(employee)
                            .build();
                }).collect(Collectors.toList());
    }


}
