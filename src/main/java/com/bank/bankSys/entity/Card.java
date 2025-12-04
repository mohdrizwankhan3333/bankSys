package com.bank.bankSys.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card extends Common{
    private String cardNumber;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private LocalDate expiry;
    private String cvv;
    @Enumerated(EnumType.STRING)
private CardStatus status;

@PrePersist
void defaultStatus() {
    this.status = CardStatus.ACTIVE;
}

public enum CardStatus {
    ACTIVE, DEACTIVE
}

    public enum CardType{
        DEBIT,CREDIT
    }

    //RelationShips

    @OneToOne
    @JoinColumn(name="customerId")
    private Customer customer;
}
