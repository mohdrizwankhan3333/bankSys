package com.bank.bankSys.mapper;

import com.bank.bankSys.dto.customerdto.*;
import com.bank.bankSys.entity.Customer;
import com.bank.bankSys.entity.Customer.Address;
import com.bank.bankSys.entity.FullName;
import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface CustomerMapper {

    // ---------------- CREATE ----------------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.Instant.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    Customer toEntity(CustomerCreateReq req);

    // ---------------- UPDATE (PATCH RULE) ----------------
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "email", ignore = true) // immutable
    @Mapping(target = "dob", ignore = true)   // immutable
    @Mapping(target = "updatedAt", expression = "java(java.time.Instant.now())")
    void updateEntity(@MappingTarget Customer entity, CustomerUpdateReq req);

    // ---------------- RESPONSE ----------------
    CustomerRes toRes(Customer entity);

    // ---------------- EMBEDDABLES ----------------
    FullName toFullName(FullNameReq req);
    FullNameReq toFullNameReq(FullName emb);

    Address toAddress(AddressReq req);
    AddressReq toAddressReq(Address emb);
}
