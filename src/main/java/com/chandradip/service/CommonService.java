package com.chandradip.service;

import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.AddressType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CommonService {

    public Employee updateEmployee(EmployeeRequest employeeRequest, Employee employee) {
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

    public List<Address> updateAddressList(List<AddressRequest> addressRequests, List<Address> addresses) {
        log.info("Inside UpdateAddressList method of CommonService. \n[ListOfAddress] : {}", addresses);
        Optional<AddressRequest> requestPermanentAddress = addressRequests.stream()
                .filter(address -> address.getAddressType() == AddressType.PERMANENT)
                .findAny();
        log.info("--------------------------------------- Requested Permanent Address---------------------\n{}", requestPermanentAddress);
        Address permanentAddress = addresses.stream()
                .filter(address -> address.getAddressType() == AddressType.PERMANENT.name())
                .findAny().get();
        if (requestPermanentAddress.isPresent()) {
                permanentAddress = updateAddress(requestPermanentAddress.get(), permanentAddress);
        }
        log.info("---------------------------------------  Permanent Address---------------------\n{}", permanentAddress);

        Optional<AddressRequest> requestCurrentAddress = addressRequests.stream()
                .filter(address -> address.getAddressType() == AddressType.CURRENT)
                .findAny();
        log.info("---------------------------------------  RequestCurrentAddress---------------------\n{}", requestCurrentAddress);

        Address currentAddress = addresses.stream()
                .filter(address -> address.getAddressType() == AddressType.CURRENT.name())
                .findAny().get();
        log.info("---------------------------------------  Current Address---------------------\n{}", currentAddress);

        if (requestCurrentAddress.isPresent()) {
            currentAddress = updateAddress(requestCurrentAddress.get(), currentAddress);
        }
        addresses.add(currentAddress);
        addresses.add(permanentAddress);
        log.info("_________________________________________________________________________________\nFinalAddressList : {}", addresses);
        return addresses;
    }

    public Address updateAddress(AddressRequest addressRequest, Address address) {
        if (addressRequest.getCity() != null) {
            address.setCity(addressRequest.getCity());
        }
        if (addressRequest.getState() != null) {
            address.setState(addressRequest.getState());
        }
        if (addressRequest.getPinCode() != null) {
            address.setPinCode(addressRequest.getPinCode());
        }
        return address;
    }
}

