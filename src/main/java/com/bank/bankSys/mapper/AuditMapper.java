package com.bank.bankSys.mapper;

import org.mapstruct.*;
import com.bank.bankSys.entity.AuditLog;
import com.bank.bankSys.dto.auditdto.AuditLogRes;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AuditMapper {

    // -------- RESPONSE ONLY --------
    AuditLogRes toRes(AuditLog entity);
}
