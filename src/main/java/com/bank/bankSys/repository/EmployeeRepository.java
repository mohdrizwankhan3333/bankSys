package com.bank.bankSys.repository;

import com.bank.bankSys.entity.Employee;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    Optional<Employee> findByRole(Employee.EmployeeRole role);
}
