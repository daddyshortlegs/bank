package com.andy.bank;

import java.util.List;

public class StatementPrinter {
    private ConsolePrinter consolePrinter;

    public StatementPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    public void print(List<Transaction> transactions) {
        String output = "";
        output += "Date       | Amount | Balance\n";

        for (Transaction transaction : transactions) {
            output += String.format("%s | %-7d| 10\n", transaction.getDate(), transaction.getAmount());
        }
        consolePrinter.output(output);
    }
}
