package com.andy.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class BankAccountServiceTest {
    @Mock
    private TransactionDate transactionDate;
    @Mock
    private ConsolePrinter printer;
    private Account account;
    private BankAccountService service;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        account = new Account(transactionDate);
        service = new BankAccountService(transactionDate, printer, account);
    }

    @Test
    void shouldPrinterEmptyStatement() {
        service.printStatement();
        verify(printer).output("Date       | Amount | Balance");
    }

    @Test
    void shouldHaveBalanceOf10_whenIDeposit() {
        service.deposit(10);
        int balance = account.getBalance();
        assertThat(balance).isEqualTo(10);
    }

    @Test
    void shouldHaveBalanceOf20_whenIDeposit() {
        service.deposit(20);
        int balance = account.getBalance();
        assertThat(balance).isEqualTo(20);
    }

    @Test
    void shouldHaveNegativeBalance_whenIWithdraw() {
        service.withdraw(10);
        int balance = account.getBalance();
        assertThat(balance).isEqualTo(-10);
    }

    @Test
    void shouldCreateATransaction_whenIDeposit() {
        String date = "10/01/2012";
        given(transactionDate.current()).willReturn(date);
        service.deposit(10);

        List<Transaction> transactions = account.getTransactions();
        assertThat(transactions).contains(new Transaction(10, date));
    }
}