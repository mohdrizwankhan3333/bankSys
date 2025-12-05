package com.bank.bankSys.service;

import com.bank.bankSys.dto.branchdto.*;
import java.util.Optional;
import java.util.List;

public interface BranchService {

    BranchRes createBranch(BranchCreateReq req);

    Optional<BranchRes> getBranchById(Long id);
    Optional<BranchRes> getBranchByCode(String code);

    List<BranchRes> getAllBranches();

    BranchRes updateBranch(Long branchId, BranchUpdate req);

    void deleteBranch(Long id);

    boolean branchExists(Long id);
}
