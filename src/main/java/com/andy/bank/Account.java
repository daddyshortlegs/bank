package com.andy.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private int balance;
    private TransactionDate transactionDate;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(TransactionDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void deposit(int amount) {
        balance += amount;
        Transaction transaction = new Transaction(amount, transactionDate.current());
        transactions.add(transaction);
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
