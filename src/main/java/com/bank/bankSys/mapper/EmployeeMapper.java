package com.bank.bankSys.mapper;
import org.mapstruct.*;
import com.bank.bankSys.entity.*;
import com.bank.bankSys.dto.employeedto.*;

@Mapper(
    componentModel="spring",
    unmappedTargetPolicy=ReportingPolicy.ERROR)

public interface EmployeeMapper {
    //create
    @Mapping(target="active",ignore=true)
    @Mapping(target="fullName",expression="FullName.fullName")
    @Mapping(target="id",ignore=true)
    @Mapping(target="createdAt",ignore=true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="branch",source="branch")
    @Mapping(target="role",expression="java(Employee.EmployeeRole.valueOf(req.role()))")
    Employee toEntity(EmployeeCreateReq req, Branch branch);

    //update
    @BeanMapping(nullValuePropertyMappingStrategy=NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target="email",ignore=true)
    @Mapping(target="fullName",ignore=true)
    @Mapping(target="role",expression="java(Employee.EmployeeRole.valueOf(req.role()))")
    void updateEntity(@MappingTarget Employee emp,EmployeeUpdateReq req);

    //embedded
    Employee.FullName toEntity(FullNameReq req);
    FullNameReq toRes(Employee.FullName entity);

    //Response
    @Mapping(target="role",expression="java(entity.getRole()==null?null:entity.getRole.name())")
    @Mapping(target="branchId" ,source="branch.id")
    EmployeeRes toRes(Employee entity);
    
}
