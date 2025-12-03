package com.bank.bankSys.dto.customerdto;

public record CustomerUpdateReq(
     FullNameReq fullName,
     String phone,
     AddressReq address
) {
    
}
