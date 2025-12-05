package com.bank.bankSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.bankSys.entity.Transaction;
public interface TransactionRepository extends JpaRepository <Transaction, Long>{

    
}
