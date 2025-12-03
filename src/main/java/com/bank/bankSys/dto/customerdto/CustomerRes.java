package com.bank.bankSys.dto.customerdto;
import java.time.Instant;
import java.time.LocalDate;

public record CustomerRes(
   Long id,
   FullNameReq fullName,
   String email,
   String phone,
   LocalDate dob,
   AddressReq address,
   Instant createdAt, 
   Instant updatedAt

) {
    
}
