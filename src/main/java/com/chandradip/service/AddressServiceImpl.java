package com.chandradip.service;

import com.chandradip.builder.AddressBuilder;
import com.chandradip.constant.AppConstant;
import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.AddressResponse;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.MessageProperties;
import com.chandradip.exception.AddressNotFoundException;
import com.chandradip.exception.EmployeeNotFoundException;
import com.chandradip.repo.AddressRepo;
import com.chandradip.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressBuilder addressBuilder;

    @Autowired
    private CommonService commonService;

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

    @Override
    public List<AddressResponse> getAllAddressByEmployee(Integer empId) {
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        return addressRepo.findByEmployee(employee)
                .stream()
                .map(address -> addressBuilder.getAddressResponse(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressResponse> getAllAddress() {
        return addressRepo.findAll()
                .stream()
                .map(address -> addressBuilder.getAddressResponse(address))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse updateAddressById(Integer addressId, AddressRequest addressRequest) {
        Address address = addressRepo.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(MessageProperties.ADDRESS_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        address = commonService.updateAddress(address, addressRequest);
        address = addressRepo.save(address);
        return addressBuilder.getAddressResponse(address);
    }

    @Override
    public Integer deleteAddressById(Integer addressId) {
        Address address = addressRepo.findById(addressId)
                .orElseThrow(() -> new AddressNotFoundException(MessageProperties.ADDRESS_NOT_FOUND.getMessage(),
                        AppConstant.NOT_FOUND));
        addressRepo.delete(address);
        return addressId;
    }
}
