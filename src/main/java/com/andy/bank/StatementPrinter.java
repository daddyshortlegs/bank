package com.andy.bank;

import java.util.List;

public class StatementPrinter {
    private ConsolePrinter consolePrinter;

    public StatementPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(List<Transaction> transactions) {
        String output = "";
        int balance = 0;
        for (Transaction transaction : transactions) {
            balance += transaction.getAmount();
            String date = transaction.getDate();
            String newDate = date.replaceAll("-", "/");
            output = String.format("%s | %-7d| %d\n", newDate, transaction.getAmount(), balance) + output;
        }
        output = "Date       | Amount | Balance\n" + output;

        consolePrinter.output(output);
    }
}
