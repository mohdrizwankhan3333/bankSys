package com.bank.bankSys.service;

import java.util.List;

import com.bank.bankSys.dto.auditdto.AuditLogRes;
import com.bank.bankSys.entity.AuditLog;

public interface AuditLogService {

    AuditLogRes save(AuditLog log);

    List<AuditLogRes> getAll();

    List<AuditLogRes> getByEntity(String entityName, String entityId);
}
