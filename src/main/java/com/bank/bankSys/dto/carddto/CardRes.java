package com.bank.bankSys.dto.carddto;
import java.time.LocalDate;

public record CardRes(
    Long id,
    String cardNumber,
    String type,
    LocalDate expiry,
    String status,
    Long customerId,
    Long linkedAccountId

) {
    
}
