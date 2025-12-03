package com.bank.bankSys.dto.branchdto;

public record AddressReq(
    String city,
    String street,
    String state,
    double pin)
    
{}
