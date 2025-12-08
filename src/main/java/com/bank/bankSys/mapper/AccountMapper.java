package com.bank.bankSys.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bank.bankSys.dto.accountdto.AccountCreateReq;
import com.bank.bankSys.dto.accountdto.AccountRes;
import com.bank.bankSys.dto.accountdto.AccountUpdateReq;
import com.bank.bankSys.entity.Account;
 
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountMapper {

    // ---------------- CREATE ----------------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true) // handled by @PrePersist
    @Mapping(target = "updatedAt", ignore = true) // handled by @PrePersist
    @Mapping(target = "type", expression = "java(Account.AccountType.valueOf(req.type()))")
    @Mapping(target = "balance", source = "req.initialDeposit")
    @Mapping(target = "transaction", ignore = true) // ignored on creation
    Account toEntity(AccountCreateReq req);

    // ---------------- UPDATE ----------------
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "status", expression = "java(Account.AccountStatus.valueOf(req.status()))")
    void updateEntity(AccountUpdateReq req, @MappingTarget
            Account account);

    // ---------------- RESPONSE ----------------
    @Mapping(target = "CustomerId", source = "customer.id")
    @Mapping(target = "BranchId", source = "branch.id")
    @Mapping(target = "accountNumber", expression = "java(account.getAccountNumber().toString())")
    AccountRes toRes(Account account);
}
