package com.chandradip.service;

import com.chandradip.builder.EmployeeBuilder;
import com.chandradip.constant.AppConstant;
import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.EmployeeResponse;
import com.chandradip.dto.RequestDTO;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.AddressType;
import com.chandradip.enums.MessageProperties;
import com.chandradip.exception.AddressNotFoundException;
import com.chandradip.exception.EmployeeNotFoundException;
import com.chandradip.repo.AddressRepo;
import com.chandradip.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private EmployeeBuilder employeeBuilder;

    @Autowired
    private CommonService commonService;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest, List<AddressRequest> addressRequests) {
        log.info("Inside EmployeeServiceImpl class addEmployee() method!");
        Employee employee = employeeBuilder.getEmployee(employeeRequest);
        log.info("Employee Entity Object is created!, [Employee] => {}", employee);
        List<Address> address = employeeBuilder.getAddress(addressRequests, employee);
        log.info("Address Entity Object is create!, [List<Address>] => {}", address);
        employee = employeeRepo.save(employee);
        log.info("Saved Employee!, [Employee] => {}", employee);
        address = addressRepo.saveAll(address);
        log.info("Saved Address!, [Address] => {}", address);
        EmployeeResponse employeeResponse = employeeBuilder.getEmployeeResponse(employee, address);
        log.info("[Employee Response] : {}", employeeResponse);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return employeeRepo.findAll()
                .stream()
                .map(employeeInfo -> employeeBuilder.getEmployeeResponse(employeeInfo, employeeInfo.getAddresses()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse updateEmployeeDetails(Integer employeeId, RequestDTO requestDTO) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        EmployeeNotFoundException.ExceptionType.EMPLOYEE_NOT_FOUND, AppConstant.NOT_FOUND));
//        log.info("Employee : {}", employee);
//        List<Address> addresses = addressRepo.findAllByEmployee(employee)
//                .orElseThrow(() -> new AddressNotFoundException(
//                        MessageProperties.ADDRESS_NOT_FOUND.getMessage(),
//                        AddressNotFoundException.ExceptionType.ADDRESS_NOT_FOUND,
//                        AppConstant.SUCCESS_CODE));
//        log.info("AddressList : {}", addresses);
        List<Address> addresses = employee.getAddresses();
        System.out.println("+++ AddressList +++ =>"+addresses);
        if (requestDTO.getEmployeeRequest() != null) {
            employee = commonService.updateEmployee(requestDTO.getEmployeeRequest(), employee);
            employee = employeeRepo.save(employee);
        }
        if (requestDTO.getAddressRequests() != null) {
            addresses = commonService.updateAddressList(requestDTO.getAddressRequests(), addresses);
            addresses = addressRepo.saveAll(addresses);
        }
        EmployeeResponse employeeResponse = employeeBuilder.getEmployeeResponse(employee, addresses);
        return employeeResponse;
    }

}
