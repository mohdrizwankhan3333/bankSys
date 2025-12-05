package com.bank.bankSys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.bankSys.entity.Branch;
import java.util.Optional;

public interface BranchRepository extends JpaRepository<Branch, Long> {

    Optional<Branch> findByCode(String code);
}
