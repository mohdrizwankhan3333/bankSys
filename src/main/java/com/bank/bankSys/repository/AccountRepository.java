package com.bank.bankSys.repository;

import com.bank.bankSys.entity.Account;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(UUID accountNumber);

    boolean existsByAccountNumber(UUID accountNumber);
}
