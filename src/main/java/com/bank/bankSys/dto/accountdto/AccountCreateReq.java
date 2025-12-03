package com.bank.bankSys.dto.accountdto;

import java.math.BigDecimal;

public record AccountCreateReq(
        Long customerId,
        Long branchId,
        String type,           // SAVING, CURRENT
        BigDecimal initialDeposit
) {}
