package com.bank.bankSys.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bank.bankSys.dto.loandto.LoanCreateReq;
import com.bank.bankSys.dto.loandto.LoanRes;
import com.bank.bankSys.dto.loandto.LoanUpdateReq;
import com.bank.bankSys.entity.Customer;
import com.bank.bankSys.entity.Loan;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface LoanMapper {

    // -------- CREATE --------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "loanNumber", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "type", expression = "java(Loan.LoanType.valueOf(req.type()))")
    @Mapping(target = "customer", source = "customer")
    Loan toEntity(LoanCreateReq req, Customer customer);


    // -------- UPDATE --------
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "loanNumber", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "type", ignore = true)
    @Mapping(target = "status", expression = "java(Loan.LoanStatus.valueOf(req.status()))")
    void updateLoanEntity(@MappingTarget Loan entity, LoanUpdateReq req);


    // -------- RESPONSE --------
    @Mapping(target = "type", expression = "java(entity.getType().name())")
    @Mapping(target = "status", expression = "java(entity.getStatus().name())")
    @Mapping(target = "customerId", source = "customer.id")
    LoanRes toRes(Loan entity);
}
