package com.bank.bankSys.dto.customerdto;

public record AddressReq(
    String city,
    String street,
    String state,
    double pin)
    
{}
