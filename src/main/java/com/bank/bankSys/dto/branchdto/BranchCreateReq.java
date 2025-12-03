package com.bank.bankSys.dto.branchdto;

public record BranchCreateReq(
    String code,
    String name,
    AddressReq address
) {
    
}
