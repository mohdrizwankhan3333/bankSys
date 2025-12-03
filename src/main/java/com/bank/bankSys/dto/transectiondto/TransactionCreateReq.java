package com.bank.bankSys.dto.transectiondto;
import java.math.BigDecimal;

public record TransactionCreateReq(
    Long accountId,
    String type,
    BigDecimal ammount,
    String description
) {
    
}
