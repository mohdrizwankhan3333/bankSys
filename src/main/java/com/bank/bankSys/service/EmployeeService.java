package com.bank.bankSys.service;
import com.bank.bankSys.dto.employeedto.*;
import com.bank.bankSys.entity.Employee;

import java.util.*;
public interface EmployeeService {
    
    EmployeeRes createEmployee(EmployeeCreateReq req);
    EmployeeRes updateEmployee(Long id, EmployeeUpdateReq req);
    void delete(Long id);
    Optional<EmployeeRes> getById(Long id);
    List<EmployeeRes> getAll();
    Optional<EmployeeRes> findByEmail(String email);
    List<EmployeeRes> findByRole(Employee.EmployeeRole role);
}
