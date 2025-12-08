package com.bank.bankSys.service;
import com.bank.bankSys.dto.transectiondto.TransactionCreateReq;
import com.bank.bankSys.dto.transectiondto.TransectionRes;
public interface TransactionService {
    TransectionRes createTransection(TransactionCreateReq req);
    TransectionRes getById(Long id);
    TransectionRes getAll();
    void delete (Long id);


    
}
