package com.minibank.AccountsService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    private final AccountRepository repository;

    public AccountsService(AccountRepository AccountModelRepository) {
        this.repository = AccountModelRepository;
    }

    public List<AccountModel> getAllAccounts() {
        return repository.findAll();
    }

    public Optional<AccountModel> getAccountById(Long id) {
        return repository.findById(id);
    }

    public Optional<AccountModel> getAccountByNumber(String accountNumber) {
        return repository.findByAccountNumber(accountNumber);
    }

    public AccountModel createAccount(AccountModel account) {
        return repository.save(account);
    }

    public AccountModel updateAccount(Long id, AccountModel accountDetails) {
        AccountModel account = repository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setAccountNumber(accountDetails.getAccountNumber());
        account.setAccountHolderName(accountDetails.getAccountHolderName());
        account.setAccountType(accountDetails.getAccountType());
        account.setBalance(accountDetails.getBalance());
        return repository.save(account);
    }

    public void deleteAccount(Long id) {
        repository.deleteById(id);
    }
}
