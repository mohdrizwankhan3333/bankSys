package com.bank.bankSys.dto.employeedto;

public record EmployeeCreateReq(
    FullNameReq fullName,
    String email,
    String role,
    Long branchId

) {
    
}
