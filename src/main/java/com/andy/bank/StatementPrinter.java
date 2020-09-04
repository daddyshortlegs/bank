package com.andy.bank;

import java.util.List;

public class StatementPrinter {
    private ConsolePrinter consolePrinter;

    public StatementPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(List<Transaction> transactions) {
        String output = "Date       | Amount | Balance\n";

        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            output += String.format("%s | %-7d| %d\n", transaction.getDate(), transaction.getAmount(), balance);
        }
        consolePrinter.output(output);
    }
}
