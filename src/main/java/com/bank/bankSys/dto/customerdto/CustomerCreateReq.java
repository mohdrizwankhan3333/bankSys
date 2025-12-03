package com.bank.bankSys.dto.customerdto;
import java.time.LocalDate;

public record CustomerCreateReq(
     FullNameReq fullName,
    String email,
    String phone,
    LocalDate dob,
    AddressReq address
) {}   

