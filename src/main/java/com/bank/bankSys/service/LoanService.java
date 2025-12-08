package com.bank.bankSys.service;
import com.bank.bankSys.dto.loandto.LoanCreateReq;
import com.bank.bankSys.dto.loandto.LoanRes;
import com.bank.bankSys.dto.loandto.LoanUpdateReq;

public interface LoanService {
    LoanRes createLoan(LoanCreateReq req);
    LoanRes updateLoan(LoanUpdateReq req);
    LoanRes getById(Long loanNumber);
    LoanRes getAll();
    void delete(Long id);
    
}
