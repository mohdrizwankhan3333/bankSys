package com.bank.bankSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.bankSys.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}
