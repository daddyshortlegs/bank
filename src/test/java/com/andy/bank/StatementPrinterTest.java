package com.andy.bank;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnEmptyStatement() {
        StatementPrinter statementPrinter = new StatementPrinter(consolePrinter);

        List<Transaction> transactions = new ArrayList<>();
        statementPrinter.print(transactions);

        verify(consolePrinter).output("Date       | Amount | Balance");
    }


}