package com.bank.bankSys.mapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bank.bankSys.dto.carddto.CardCreateReq;
import com.bank.bankSys.dto.carddto.CardRes;
import com.bank.bankSys.dto.carddto.CardUpdateReq;
import com.bank.bankSys.entity.Card;
import com.bank.bankSys.entity.Customer;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CardMapper {

    // -------- CREATE --------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "cvv", ignore = true)
    @Mapping(target = "status", ignore = true) // handled by @PrePersist
    @Mapping(target = "cardNumber", ignore = true) // generated
    @Mapping(target = "type", expression = "java(Card.CardType.valueOf(req.type()))")
    @Mapping(target = "customer", source = "customer") // pass entity from service
    Card toEntity(CardCreateReq req, Customer customer);

    // -------- UPDATE --------
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cardNumber", ignore = true)
    @Mapping(target = "cvv", ignore = true)
    @Mapping(target = "customer", ignore = true)
    void updateCard(@MappingTarget Card card, CardUpdateReq req);

    // -------- RESPONSE --------
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "linkedAccountId", ignore = true) // set manually in service if needed
    CardRes toRes(Card entity);

}
