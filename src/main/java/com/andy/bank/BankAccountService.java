package com.andy.bank;

public class BankAccountService implements AccountService {
    private final TransactionDate transactionDate;
    private final ConsolePrinter printer;

    public BankAccountService(TransactionDate transactionDate, ConsolePrinter printer) {

        this.transactionDate = transactionDate;
        this.printer = printer;
    }

    @Override
    public void deposit(int amount) {

    }

    @Override
    public void withdraw(int amount) {

    }

    @Override
    public void printStatement() {
        printer.output("Date       | Amount | Balance");
    }
}
