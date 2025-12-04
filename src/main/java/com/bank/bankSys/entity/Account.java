package com.bank.bankSys.entity;
import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter 
@AllArgsConstructor 
@NoArgsConstructor
@Setter
public class Account extends Common{
    
private UUID accountNumber;

@PrePersist
public void initAccountNumber() {
    if (accountNumber == null) {
        accountNumber = UUID.randomUUID();
    }
}

    
    @Enumerated(EnumType.STRING)
    private AccountType type;
    public enum AccountType{
        SAVING, CURRENT
    }

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountStatus  status;

    @PrePersist
    public void initStatus() {
    if (status == null) {
        status = AccountStatus.ACTIVE;
    }
}
    public enum AccountStatus {
        ACTIVE,
        BLOCKED
    }
    
    //RelationShips
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Customer_id")
    Customer customer;

    @OneToMany(mappedBy="account", cascade=CascadeType.ALL)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
}

