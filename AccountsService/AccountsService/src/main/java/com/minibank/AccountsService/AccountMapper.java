package com.minibank.AccountsService;

import java.time.LocalDateTime;

public class AccountMapper {
    public static AccountDTO toDTO(AccountModel accountModel) {
        return new AccountDTO(
                accountModel.getBranchNumber(),
                accountModel.getAccountNumber(),
                accountModel.getAccountHolderName(),
                accountModel.getAccountHolderDocument(),
                accountModel.getAccountType(),
                accountModel.getBalance(),
                accountModel.getBalanceCurrency()
        );
    }

    public static AccountModel toModel(AccountDTO accountDTO) {
        return new AccountModel(
                null,
                accountDTO.branchNumber(),
                accountDTO.accountNumber(),
                accountDTO.accountHolderName(),
                accountDTO.accountHolderDocument(),
                accountDTO.accountType(),
                accountDTO.balance(),
                accountDTO.balanceCurrency(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
