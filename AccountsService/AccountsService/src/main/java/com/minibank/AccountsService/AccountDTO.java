package com.minibank.AccountsService;

import java.math.BigDecimal;

public record AccountDTO (
        String branchNumber,
        String accountNumber,
        String accountHolderName,
        String accountHolderDocument,
        String accountType,
        BigDecimal balance,
        String balanceCurrency
) { }
