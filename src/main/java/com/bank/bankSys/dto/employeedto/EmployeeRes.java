package com.bank.bankSys.dto.employeedto;

public record EmployeeRes(
    Long id,
    FullNameReq fullName,
    String email,
    String role,
    Boolean active,
    Long branchId
) {
    
}
