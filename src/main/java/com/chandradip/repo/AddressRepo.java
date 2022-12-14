package com.chandradip.repo;

import com.chandradip.entity.Address;
import com.chandradip.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

    Optional<List<Address>> findAllByEmployee(Employee employee);
}
