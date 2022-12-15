package com.chandradip.repo;

import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {
    List<Address> findByEmployee(Employee employee);
}
