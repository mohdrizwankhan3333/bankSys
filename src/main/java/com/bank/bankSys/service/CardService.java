package com.bank.bankSys.service;

import com.bank.bankSys.dto.carddto.*;
import com.bank.bankSys.entity.Card;
import java.util.Optional;
import java.util.List;

public interface CardService {

    CardRes createCard(CardCreateReq req);
    CardRes updateCard(Long cardId, CardUpdateReq req);

    Optional<CardRes> getCardById(Long cardId);
    List<CardRes> getAllCards();

    void deleteById(Long id);

    CardRes getCardByNumber(String cardNumber);
    Optional<CardRes> getCardByType(Card.CardType type);

    Boolean cardExists(String cardNumber);
}
