package com.chandradip.service;

import com.chandradip.builder.AddressBuilder;
import com.chandradip.constant.AppConstant;
import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.AddressResponse;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.MessageProperties;
import com.chandradip.exception.EmployeeNotFoundException;
import com.chandradip.repo.AddressRepo;
import com.chandradip.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressBuilder addressBuilder;
    @Override
    public AddressResponse addAddress(Integer employeeId ,AddressRequest request) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        Address address = addressBuilder.getAddress(request);
        address.setEmployee(employee);
        address = addressRepo.save(address);
        return addressBuilder.getAddressResponse(address);
    }
}
