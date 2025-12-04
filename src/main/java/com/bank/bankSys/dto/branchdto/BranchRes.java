package com.bank.bankSys.dto.branchdto;

public record BranchRes(
    Long branchId,
    String code,
    String name,
    AddressReq address
){}
