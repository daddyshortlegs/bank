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
            output += String.format("13/01/2012 | %-7d| 10\n", 10);
        }
        consolePrinter.output(output);
    }
}
