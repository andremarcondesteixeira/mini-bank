CREATE TABLE account (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    branch_number varchar(20) NOT NULL,
    account_number VARCHAR(20) NOT NULL,
    account_holder_name VARCHAR(100) NOT NULL,
    account_holder_document varchar(20) NOT NULL,
    account_type VARCHAR(10) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    balance_currency CHAR(3) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    UNIQUE(branch_number, account_number)
);
