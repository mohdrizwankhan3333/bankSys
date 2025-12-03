package com.bank.bankSys.dto.accountdto;
import java.math.BigDecimal;
import java.time.Instant;

public record AccountRes(
    Long id,
    String accountNumber,
    String type,
    BigDecimal balance,
    String status,
    Long CustomerId,
    Long BranchId,
    Instant createdAt,
    Instant updatedAt
) {
    
}
