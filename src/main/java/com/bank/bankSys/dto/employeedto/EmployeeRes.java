package com.bank.bankSys.dto.employeedto;

public record EmployeeRes(
    Long id,
    FullName fullName,
    String email,
    String role,
    Boolean active,
    long branchId
) {
    
}
