package com.andy.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private TransactionDate transactionDate;
    private List<Transaction> transactions = new ArrayList<>();

    public Account(TransactionDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void deposit(int amount) {
        Transaction transaction = new Transaction(amount, transactionDate.current());
        transactions.add(transaction);
    }

    public void withdraw(int amount) {
        Transaction transaction = new Transaction(-amount, transactionDate.current());
        transactions.add(transaction);
    }

    public int getBalance() {
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
        }
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
