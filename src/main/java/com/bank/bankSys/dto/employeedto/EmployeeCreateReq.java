package com.bank.bankSys.dto.employeedto;

public record EmployeeCreateReq(
    FullName fullName,
    String email,
    String role,
    Long branchId

) {
    
}
