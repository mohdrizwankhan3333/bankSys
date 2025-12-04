package com.bank.bankSys.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Common {

    @Embedded
    private FullName fullName;

    private String email;
    private String phone;
    private LocalDate dob;

    @Embedded
    private Address address;

    @Embeddable
    @Getter
    @Setter
    public static class Address {
        private String city;
        private String street;
        private String state;
        private double pin;
    }

    // Relationships
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToOne(mappedBy="customer",cascade=CascadeType.ALL)
    private Card card;

    @OneToMany(mappedBy="customer", cascade=CascadeType.ALL)
    private List<Loan> loan;

    
    
}
