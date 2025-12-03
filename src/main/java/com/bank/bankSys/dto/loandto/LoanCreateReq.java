package com.bank.bankSys.dto.loandto;
import java.math.BigDecimal;

public record LoanCreateReq( 
    Long customerId,
    String type,
    BigDecimal amount,
    Integer tenureMonths,
    BigDecimal interestrate){}

