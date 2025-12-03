package com.bank.bankSys.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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


    public enum CardStatus{
        ACTIVE,DEACTIVE
    }

    public enum CardType{
        DEBIT,CREDIT
    }

    //RelationShips

    @OneToOne
    @JoinColumn(name="card_id")
    private Customer customer;
}
