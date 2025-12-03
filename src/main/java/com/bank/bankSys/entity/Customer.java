package com.bank.bankSys.entity;

import lombok.*;
import java.time.LocalDate;
import jakarta.persistence.*;
import java.util.List;

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
