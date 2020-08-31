package com.andy.bank;

public class BankAccountService implements AccountService {
    private final TransactionDate transactionDate;
    private final ConsolePrinter printer;
    private Account account;

    public BankAccountService(TransactionDate transactionDate, ConsolePrinter printer, Account account) {
        this.transactionDate = transactionDate;
        this.printer = printer;
        this.account = account;
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
        printer.output("Date       | Amount | Balance");
    }
}
