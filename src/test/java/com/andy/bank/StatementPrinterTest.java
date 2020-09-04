package com.andy.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class StatementPrinterTest {

    @Mock
    private ConsolePrinter consolePrinter;
    private StatementPrinter statementPrinter;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        statementPrinter = new StatementPrinter(consolePrinter);
    }

    @Test
    void shouldReturnEmptyStatement() {
        List<Transaction> transactions = new ArrayList<>();
        statementPrinter.print(transactions);

        verify(consolePrinter).output("Date       | Amount | Balance\n");
    }

    @Test
    void shouldReturnStatement_withADeposit() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(10, "13/01/2012"));
        statementPrinter.print(transactions);

        verify(consolePrinter).output(
                "Date       | Amount | Balance\n" +
                        "13/01/2012 | 10     | 10\n"
        );
    }

    @Test
    void shouldReturnStatement_withAWithdrawal() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(-10, "13/01/2012"));
        statementPrinter.print(transactions);

        verify(consolePrinter).output(
                "Date       | Amount | Balance\n" +
                        "13/01/2012 | -10    | 10\n"
        );
    }

}