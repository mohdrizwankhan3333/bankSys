package com.bank.bankSys.entity;
import lombok.*;
import java.time.Instant;
import java.math.BigDecimal;
import jakarta.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction extends Common{

    @Enumerated(EnumType.STRING)
    private TxType type;

    private BigDecimal amount;
    private String description;
    private Instant timeStamp;
    private BigDecimal balanceAfter;

    public enum TxType{
        CREDIT,DEBIT
    }

//RelationShip
@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="account_id")
Account account;
    
}
