package com.bank.bankSys.dto.auditdto;
import java.time.Instant;

public record AuditLogRes(
    Long id,
    String entityName,
    String entityId,
    String operation,
    Instant timeStamp,
    String performedBy
) {

    
}
