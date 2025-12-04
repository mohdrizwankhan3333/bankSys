package com.bank.bankSys.dto.carddto;
import java.time.LocalDate;
public record CardCreateReq (
    Long CustomerId,
    Long linkedAccountId,
    String type,
    LocalDate expiry)
    {
    

}
