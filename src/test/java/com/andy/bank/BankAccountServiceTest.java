package com.andy.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class BankAccountServiceTest {
    @Mock
    private TransactionDate transactionDate;
    @Mock
    private ConsolePrinter printer;
    @Mock
    private StatementPrinter statementPrinter;

    private Account account;
    private BankAccountService service;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        account = new Account(transactionDate);
        service = new BankAccountService(transactionDate, printer, account, statementPrinter);
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
        deposit("10/01/2012", 10);

        List<Transaction> transactions = account.getTransactions();
        assertThat(transactions).contains(new Transaction(10, "10/01/2012"));
    }

    @Test
    void shouldCreateATransaction_whenIWithdraw() {
        withdraw("11/02/2016", 20);

        List<Transaction> transactions = account.getTransactions();
        assertThat(transactions).contains(new Transaction(-20, "11/02/2016"));
    }

    @Test
    void shouldPrinterEmptyStatement() {
        service.printStatement();
        verify(printer).output("Date       | Amount | Balance");
    }

    @Test
    void shouldPrintTransactions() {
        deposit("14/01/2012", 10);
        deposit("15/01/2012", 15);

        service.printStatement();

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(10, "14/01/2012"));
        transactions.add(new Transaction(15, "15/01/2012"));

        verify(statementPrinter).print(transactions);
    }

    private void deposit(String date, int amount) {
        given(transactionDate.current()).willReturn(date);
        service.deposit(amount);
    }

    private void withdraw(String date, int amount) {
        given(transactionDate.current()).willReturn(date);
        service.withdraw(amount);
    }

}