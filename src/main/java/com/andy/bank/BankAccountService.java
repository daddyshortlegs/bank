package com.andy.bank;

public class BankAccountService implements AccountService {
    private final TransactionDate transactionDate;
    private final ConsolePrinter printer;
    private Account account;
    private StatementPrinter statementPrinter;

    public BankAccountService(TransactionDate transactionDate, ConsolePrinter printer, Account account, StatementPrinter statementPrinter) {
        this.transactionDate = transactionDate;
        this.printer = printer;
        this.account = account;
        this.statementPrinter = statementPrinter;
    }

    @Override
    public void deposit(int amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        account.withdraw(amount);
    }

    @Override
    public void printStatement() {
        statementPrinter.print(account.getTransactions());
    }
}
