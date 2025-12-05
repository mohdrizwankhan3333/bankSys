package com.bank.bankSys.mapper;

import org.mapstruct.*;
import com.bank.bankSys.entity.Transaction;
import com.bank.bankSys.entity.Account;
import com.bank.bankSys.dto.transectiondto.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface TransactionMapper {

    // ---------- CREATE ----------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "timeStamp", ignore = true)                     // will set in service
    @Mapping(target = "balanceAfter", ignore = true)                  // set after processing
    @Mapping(target = "type",
             expression = "java(Transaction.TxType.valueOf(req.type()))")
    @Mapping(target = "account", source = "account")
    Transaction toEntity(TransactionCreateReq req, Account account);


    // ---------- RESPONSE ----------
    @Mapping(target = "type",
             expression = "java(entity.getType().name())")
    @Mapping(target = "accountId", source = "account.id")
    TransectionRes toRes(Transaction entity);
}
