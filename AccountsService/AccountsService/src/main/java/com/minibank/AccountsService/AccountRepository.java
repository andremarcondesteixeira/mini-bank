package com.minibank.AccountsService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    Optional<AccountModel> findByBranchNumberAndAccountNumber(String branchNumber, String accountNumber);
}
