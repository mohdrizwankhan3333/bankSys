package com.bank.bankSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.bank.bankSys.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

    Optional<Card> findByNumber(String cardNumber);

    boolean existsByNumber(String cardNumber);

    Optional<Card> findByType(Card.CardType type);
}
