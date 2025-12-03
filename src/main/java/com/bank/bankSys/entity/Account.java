package com.bank.bankSys.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity @Getter @AllArgsConstructor @NoArgsConstructor
@Setter
public class Account extends Common{
    private UUID accountNumber ;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    public enum AccountType{
        SAVING, CURRENT
    }

    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private AccountStatus  status;
     
    public enum AccountStatus {
        ACTIVE,
        BLOCKED
    }
    
    //RelationShips
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Customer_id")
    Customer customer;

    @OneToMany(mappedBy="account", cascade=CascadeType.ALL)
    private Transaction transection;
}

