package com.bank.bankSys.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends Common {
    private String email;
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    public enum EmployeeRole{
        MANAGER,OFFICER
    }

    private Boolean active;

    @Embedded
    private FullName fullName;

    @Embeddable
    @Getter
    @Setter
    public static class FullName{
        private String firstName;
        private String secondname ;
    }
    //RelationShips
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="branch_id")
    private Branch branch;
}
