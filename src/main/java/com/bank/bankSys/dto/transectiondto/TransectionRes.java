package com.bank.bankSys.dto.transectiondto;
import java.math.BigDecimal;
import java.time.Instant;

public record TransectionRes(
    Long id,
    String type,
    BigDecimal amount,
    String description,
    Instant timeStamp,
    BigDecimal balanceAfter,
    Long accountId
) {
    
}
