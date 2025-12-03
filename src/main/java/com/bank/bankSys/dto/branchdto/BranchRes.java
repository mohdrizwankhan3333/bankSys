package com.bank.bankSys.dto.branchdto;

public record BranchRes(
    Long id,
    String code,
    String name,
    AddressReq address
){}
