package com.andy.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class BankAccountServiceTest {
    @Mock
    private TransactionDate transactionDate;
    @Mock
    private ConsolePrinter printer;
    private BankAccountService service;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        service = new BankAccountService(transactionDate, printer);
    }

    @Test
    void shouldPrinterEmptyStatement() {
        service.printStatement();
        verify(printer).output("Date       | Amount | Balance");
    }
}