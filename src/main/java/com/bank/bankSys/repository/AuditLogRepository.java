
package com.bank.bankSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.List;

import com.bank.bankSys.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // fetch logs by entity
    List<AuditLog> findByEntityName(String entityName);

    // fetch logs for specific record
    List<AuditLog> findByEntityId(String entityId);

    // fetch operation type (CREATE / UPDATE / DELETE)
    List<AuditLog> findByOperation(String operation);

    // fetch logs in time range
    List<AuditLog> findByTimeStampBetween(Instant start, Instant end);

    // fetch logs by actor
    List<AuditLog> findByPerformedBy(String performedBy);
}
