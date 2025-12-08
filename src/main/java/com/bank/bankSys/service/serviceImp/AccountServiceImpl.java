package com.bank.bankSys.service.serviceImp;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bank.bankSys.dto.accountdto.AccountCreateReq;
import com.bank.bankSys.dto.accountdto.AccountRes;
import com.bank.bankSys.dto.accountdto.AccountUpdateReq;
import com.bank.bankSys.entity.Account;
import com.bank.bankSys.exception.NotFoundException;
import com.bank.bankSys.mapper.AccountMapper;
import com.bank.bankSys.repository.AccountRepository;
import com.bank.bankSys.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repo;
    private final AccountMapper mapper;

    // ---------------- CREATE ----------------
    @Override
    public AccountRes createAccount(AccountCreateReq req) {
        log.info("account.create request customerId={}", req.customerId());

        Account entity = mapper.toEntity(req);
        entity.setAccountNumber(UUID.randomUUID());

        Account saved = repo.save(entity);

        log.info("account.create.success id={} number={}", 
                 saved.getId(), saved.getAccountNumber());

        return mapper.toRes(saved);
    }

    // ---------------- READ ----------------
    @Override
    public Optional<AccountRes> getAccountById(Long id) {
        log.info("account.fetch.id id={}", id);

        return repo.findById(id)
                .map(mapper::toRes);
    }

    @Override
    public Optional<AccountRes> getAccountByNumber(UUID number) {
        log.info("account.fetch.number number={}", number);

        if (number == null) {
            log.warn("account.fetch.number null_number");
            return Optional.empty();
        }

        return repo.findByAccountNumber(number)
                .map(mapper::toRes);
    }

    @Override
    public List<AccountRes> getAllAccounts() {
        log.info("account.fetch.all");

        List<Account> list = repo.findAll();

        return list.isEmpty()
                ? List.of()
                : list.stream().map(mapper::toRes).toList();//convert all the entity attributes to dto
    }

    // ---------------- UPDATE ----------------
    @Override
    public AccountRes updateAccount(Long id, AccountUpdateReq req) {
        log.info("account.update request id={}", id);

        Account acc = repo.findById(id)
                .orElseThrow(() -> {
                    log.error("account.update.not_found id={}", id);
                    return new NotFoundException("Account not found");
                });

        mapper.updateEntity(req, acc);//get Updation and account to update

        Account saved = repo.save(acc);//save Updated Account.

        log.info("account.update.success id={} balance={}", 
                 saved.getId(), saved.getBalance());
        return mapper.toRes(saved);
    }

    // ---------------- DELETE ----------------
    @Override
    public void deleteAccount(Long id) {
        log.info("account.delete request id={}", id);

        if (!repo.existsById(id)) {
            log.error("account.delete.not_found id={}", id);
            throw new NotFoundException("Account not found");
        }

        repo.deleteById(id);

        log.info("account.delete.success id={}", id);
    }

    // ---------------- CUSTOM CHECK ----------------
    @Override
    public boolean accountExists(UUID number) {
        boolean exists = repo.existsByAccountNumber(number);

        log.info("account.exists number={} exists={}", number, exists);

        return exists;
    }
}
