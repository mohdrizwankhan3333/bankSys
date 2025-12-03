package com.bank.bankSys.dto.loandto;
import java.time.Instant;
import java.math.BigDecimal;
public record LoanRes(
    Long id,
    String loanNumber,
    String type,
    BigDecimal amount,
    Integer tenureMonths,
    BigDecimal interestRate,
    String status,
    Long customerId,
    Instant createdAt

) {
    
}
