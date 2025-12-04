package com.bank.bankSys.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.bank.bankSys.dto.branchdto.AddressReq;
import com.bank.bankSys.dto.branchdto.BranchCreateReq;
import com.bank.bankSys.dto.branchdto.BranchRes;
import com.bank.bankSys.dto.branchdto.BranchUpdate;
import com.bank.bankSys.entity.Branch;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface BranchMapper {

    // ------- CREATE -------
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    Branch toEntity(BranchCreateReq req);

    // ------- UPDATE -------
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "code", ignore = true)       // immutable
    @Mapping(target = "employees", ignore = true)
    @Mapping(target = "accounts", ignore = true)
    void updateEntity(@MappingTarget Branch branch, BranchUpdate dto);

    // ------- RESPONSE -------
    @Mapping(target = "branchId", source = "id")
    BranchRes toRes(Branch entity);

    // ------- EMBEDDED ADDRESS -------
    Branch.Address toAddress(AddressReq req);
    AddressReq toAddressReq(Branch.Address address);
}
