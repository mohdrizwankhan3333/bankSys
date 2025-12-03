package com.bank.bankSys.entity;
import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Loan extends Common {
    private String loanNumber;
    private BigDecimal amount;
    private int tenureMonths;
    private BigDecimal interestRate;

    @Enumerated(EnumType.STRING)
    private LoanType type;

    public enum LoanType{
        HOME,VAHICLE,PERSONAL
    }

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    public enum LoanStatus{
        APPROVED, REJECTED, ACTIVE, CLOSED
    }

    //RelationShip

    @ManyToOne( fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;
    
}
