package com.bank.bankSys.entity;
import lombok.*;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AuditLog extends Common{
    private String entityName;
    private String entityId;
    private String operation;
    private Instant timeStamp;
    private String performedBy;
    
}
