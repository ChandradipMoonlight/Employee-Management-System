package com.chandradip.service;

import com.chandradip.builder.EmployeeBuilder;
import com.chandradip.constant.AppConstant;
import com.chandradip.dto.AddressRequest;
import com.chandradip.dto.EmployeeRequest;
import com.chandradip.dto.EmployeeResponse;
import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import com.chandradip.enums.MessageProperties;
import com.chandradip.exception.EmployeeException;
import com.chandradip.repo.AddressRepo;
import com.chandradip.repo.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CommonService commonService;
    @Autowired
    private EmployeeBuilder employeeBuilder;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        log.info("Inside EmployeeServiceImpl class addEmployee() method!");
        Employee employee = employeeBuilder.getEmployee(employeeRequest);
        log.info("Employee Entity Object is created!, [Employee] => {}", employee);
        employee = employeeRepo.save(employee);
        log.info("Saved Employee!, [Employee] => {}", employee);
        EmployeeResponse employeeResponse = employeeBuilder.getEmployeeResponse(employee);
        log.info("[Employee Response] : {}",employeeResponse);
        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return employeeRepo.findAll()
                 .stream()
                .map(employeeInfo -> employeeBuilder.getEmployeeResponse(employeeInfo))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer employeeId) {
         Employee employee = employeeRepo.findById(employeeId)
                 .orElseThrow(() -> new EmployeeException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                         EmployeeException.ExceptionType.EMPLOYEE_NOT_FOUND, AppConstant.NOT_FOUND));
        return employeeBuilder.getEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployeeById(Integer empId, EmployeeRequest employeeRequest) {
        log.info("Inside EmployeeService Class updateEmployeeById() method," +
                " \n[EmployeeId] : => {},\n[EmployeeRequest] : => ", empId, employeeRequest);
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(() -> new EmployeeException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        EmployeeException.ExceptionType.EMPLOYEE_NOT_FOUND, AppConstant.NOT_FOUND));
        employee = commonService.updateEmployee(employee, employeeRequest);
        employee = employeeRepo.save(employee);
        log.info("{}.\n[updated Employee] : => {}", MessageProperties.UPDATE_EMPLOYEE.getMessage(), employee);
        return employeeBuilder.getEmployeeResponse(employee);
    }

    @Override
    public Integer deleteEmployeeById(Integer empId) {
        log.info("Inside EmployeeService Class deleteEmployeeById() method," +
                " \n[EmployeeId] : => {}", empId);
        Employee employee = employeeRepo.findById(empId)
                .orElseThrow(() -> new EmployeeException(MessageProperties.EMPLOYEE_NOT_FOUND.getMessage(),
                        EmployeeException.ExceptionType.EMPLOYEE_NOT_FOUND, AppConstant.NOT_FOUND));
        log.info("Deleted Employee : => {}", employee);
        employeeRepo.delete(employee);
        return empId;
    }
}
