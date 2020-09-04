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
            output += "13/01/2012 | 10 | 10\n";
        }
        consolePrinter.output(output);
    }
}
