package com.bank.bankSys.entity;
import java.util.List;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch extends Common{
    private  String  code;
    private String name;
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

    //RelationShips
    @OneToMany(mappedBy="branch", cascade=CascadeType.ALL)
    private List<Employee> employees;
    
}
