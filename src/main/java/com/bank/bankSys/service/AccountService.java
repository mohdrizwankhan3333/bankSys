package com.bank.bankSys.service;

import com.bank.bankSys.dto.accountdto.AccountCreateReq;
import com.bank.bankSys.dto.accountdto.AccountRes;
import com.bank.bankSys.dto.accountdto.AccountUpdateReq;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountService {

    // ---------------- CREATE ----------------
    AccountRes createAccount(AccountCreateReq request);

    // ---------------- READ ----------------
    Optional<AccountRes> getAccountById(Long id);
    Optional<AccountRes> getAccountByNumber(UUID accountNumber);
    List<AccountRes> getAllAccounts();

    // ---------------- UPDATE ----------------
    AccountRes updateAccount(Long accountId, AccountUpdateReq request);

    // ---------------- DELETE ----------------
    void deleteAccount(Long id);

    // ---------------- CUSTOM CHECK ----------------
    boolean accountExists(UUID accountNumber);
}
