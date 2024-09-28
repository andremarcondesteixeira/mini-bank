package com.minibank.AccountsService;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountsService {

    private final AccountRepository repository;

    public AccountsService(AccountRepository AccountModelRepository) {
        this.repository = AccountModelRepository;
    }

    public List<AccountDTO> getAllAccounts() {
        return repository.findAll().stream().map(AccountMapper::toDTO).collect(Collectors.toList());
    }

    public Optional<AccountDTO> getAccountById(Long id) {
        return repository.findById(id).map(AccountMapper::toDTO);
    }

    public Optional<AccountDTO> getAccountByBranchNumberAndAccountNumber(String branchNumber, String accountNumber) {
        return repository.findByBranchNumberAndAccountNumber(branchNumber, accountNumber).map(AccountMapper::toDTO);
    }

    public AccountDTO createAccount(AccountDTO account) {
        return AccountMapper.toDTO(repository.save(AccountMapper.toModel(account)));
    }

    public AccountDTO updateAccount(Long id, AccountDTO accountDetails) {
        AccountModel account = repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountHolderDocument(accountDetails.accountHolderDocument());
        account.setAccountNumber(accountDetails.accountNumber());
        account.setAccountType(accountDetails.accountType());
        account.setBalance(accountDetails.balance());
        account.setBranchNumber(accountDetails.branchNumber());
        account.setBalanceCurrency(accountDetails.balanceCurrency());
        account.setAccountHolderName(accountDetails.accountHolderName());
        account.setUpdatedAt(LocalDateTime.now());
        repository.save(account);
        return AccountMapper.toDTO(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
