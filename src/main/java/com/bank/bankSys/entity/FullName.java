package com.bank.bankSys.entity;
import jakarta.persistence.Embeddable;
import lombok.*;
@Embeddable
@Getter
@Setter
public class FullName{
    private String firstName;
    private String lastName;
}